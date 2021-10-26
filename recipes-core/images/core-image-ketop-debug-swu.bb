DESCRIPTION = "SWU Image for Ketop debug"

SRC_URI = "file://preinst-rootfs1.sh \
	   file://preinst-rootfs2.sh \
	   file://postinst.sh \
	   file://sw-description \
	   "

inherit swupdate

LICENSE = "CLOSED"

IMAGE_DEPENDS = "core-image-ketop-debug"

SWUPDATE_IMAGES = " \
		  core-image-ketop-debug \
		  "

SWUPDATE_IMAGES_FSTYPES[core-image-ketop-debug] = ".tar.gz"
