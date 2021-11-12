DESCRIPTION = "Production image for Keba Ketop"

IMAGE_FSTYPES = "squashfs-xz"

require core-image-ketop.inc

IMAGE_FEATURES += " ssh-server-openssh debug-tweaks read-only-rootfs"


addMntData() {
	     install -d -m 0755 --owner=root ${IMAGE_ROOTFS}/mnt/data	    
}

# we have to do this in a postprocess command since the values
# are written at postprocess time, not during the recipe :-(
# this will replace the tmpfs location with a permanent location
changeSshdHostKeyLocation() {
        sed -i 's/HostKey \/var\/run\/ssh\//HostKey \/mnt\/data\/ssh\//g' ${IMAGE_ROOTFS}/etc/ssh/sshd_config_readonly
}

ROOTFS_POSTPROCESS_COMMAND += " addMntData; changeSshdHostKeyLocation; "

