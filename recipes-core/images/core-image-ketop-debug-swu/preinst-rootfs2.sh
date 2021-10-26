#!/bin/bash

if [[ ! -f /boot/EFI/BOOT/grubenv ]]; then
    grub-editenv /boot/EFI/BOOT/grubenv create
fi

umount /dev/disk/by-partlabel/rootfs2 || /bin/true

yes | mkfs.ext4 /dev/disk/by-partlabel/rootfs2
