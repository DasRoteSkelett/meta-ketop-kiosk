# meta-ketop-kiosk

This is not only the meta layer for the ketop kiosk yocto distribution but
also holds the [kas](https://github.com/siemens/kas) configuration for building
and versioning of the ketop kiosk yocto distribution / firmware. 

## Instruction to build

Basically, you can use kas to build the image. It is advisable to set
KAS_WORK_DIR to some place, if you do not want the meta-ketop-kiosk directory
to be cluttered with all kinds of layers. 

There are [different possibilities to build with kas]
(https://kas.readthedocs.io/en/latest/userguide.html).

If your have kas installed as well as all the needed packages for yocto
(see [yocto quick start guide](http://docs.yoctoproject.org/brief-yoctoprojectqs/#build-host-packages))
you can build the distribution by typing
```bash
kas build ketop.yml
```

kas will check out the needed meta layers as well as starting `bitbake`
and build the firmware images defined by this layer and ketop.yml.

## Initial install on Ketop

To create an initial disk image (with partition table, boot loader etc.)
you will have to use the `wic` tool first. See the [yocto development manual](https://www.yoctoproject.org/docs/latest/dev-manual/dev-manual.html#creating-partitioned-images-using-wic)
for more details on wic. There are two partitions provided by the
meta-ketop layer: `ketop-dual-boot` and `ketop-dual-boot-squashfs`.
The first one creates two approx. 3 GB partitions rootfs1 and
rootfs2 with the rootfs image, while `ketop-dual-boot-squashfs`
will reserve much less space for the rootfs (which needs to be
squashfs) and have a larger partition mounted at /mnt/data
which is ext4 and is mounted r/w.

To create an "debug" system with ext4 fs and root mounted r/w, use
```bash
kas shell ketop.yml
wic create ketop-dual-boot -e core-image-ketop-debug
```
For the read only squashfs, go with:
```bash
kas shell ketop.yml
wic create ketop-dual-boot-squashfs -e core-image-ketop-production
```

To write the file directly on the disk, boot the ketop with a bootstick
(e.g. [clonezilla](https://clonezilla.org/) ). Boot into cmdline, aquire an
IP address for your network. As root, start netcat to listen do the network
for an device image:

```bash
nc -l -p 19000 | bzip2 -d | dd bs=16M of=/dev/mmcblk1 iflag=fullblock oflag=direct status=progress
```
Note: to write to mSATA, use /dev/sda instead of /dev/mmcblk1.


On your PC (host), start the transfer:

```bash
dd bs=16M if=./ketop-dual-boot-*-sda.direct | bzip2 -c |  nc -N <IP_KETOP> 19000
```

This will take some time, unfortunately. Some speedup can be made if you use
`pbzip2` instead of `bzip2`.

After everything is finished, reboot the ketop. 

## Updating the ketop

Once, you have yocto running on the ketop,
you can scp the swu file to the machine and then run the update script, e.g.

```bash
scp tmp/deploy/images/ketop/core-image-ketop-debug-swu-ketop.swu root@<KETOP_IP_ADDRESS_HERE>:
ssh root@<KETOP_IP_ADDRESS_HERE>
update-ketop.sh core-image-ketop-debug-swu-ketop.swu
```

On success, the script will install the image into the other root partition and
issue a reboot. 

## Dependencies

You can find the depending layers in the file `ketop.yml`

## Patches

Please submit any patches against the meta-ketop-kiosk layer to the maintainer:

Maintainer: Matthias Schoepfer <m.schoepfer@rethinkrobotics.com>

