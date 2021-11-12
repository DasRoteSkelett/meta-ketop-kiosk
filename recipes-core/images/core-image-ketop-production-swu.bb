DESCRIPTION = "SWU Image for Ketop production"

SRC_URI = "file://preinst-rootfs1.sh \
	   file://preinst-rootfs2.sh \
	   file://postinst.sh \
	   file://sw-description \
	   "

inherit swupdate

LICENSE = "CLOSED"

IMAGE_DEPENDS = "core-image-ketop-production"

SWUPDATE_IMAGES = " \
		  core-image-ketop-production \
		  "

SWUPDATE_IMAGES_FSTYPES[core-image-ketop-production] = ".squashfs-xz"
