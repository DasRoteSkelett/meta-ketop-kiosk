# Simple initramfs image. 
DESCRIPTION = "Small helper to start plymouth as soon as possible and then \
go on with the boot process. Bases on core-image-minimal-initramfs."

INITRAMFS_SCRIPTS ?= "\
		      initramfs-module-debug \
		      initramfs-module-udev \
                      initramfs-framework-base \
		      initramfs-module-rootfs \
		      initramfs-module-e2fs \
		      initramfs-module-exec \
                     "

PACKAGE_INSTALL = "${INITRAMFS_SCRIPTS} ${VIRTUAL-RUNTIME_base-utils} udev base-passwd ${ROOTFS_BOOTSTRAP_INSTALL} plymouth"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "${MLPREFIX}core-image-ketop-initramfs"
IMAGE_NAME_SUFFIX ?= ""
IMAGE_LINGUAS = ""

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

# Use the same restriction as initramfs-module-install
COMPATIBLE_HOST = '(x86_64.*|i.86.*|arm.*|aarch64.*)-(linux.*|freebsd.*)'
