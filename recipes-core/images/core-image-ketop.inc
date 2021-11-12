IMAGE_INSTALL = "packagegroup-core-boot \
		 ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += " splash hwcodecs weston "

inherit core-image             
inherit extrausers

IMAGE_INSTALL += " \
	      e2fsprogs \
	      e2fsprogs-mke2fs \
	      dbus \
	      grep \
	      coreutils \
	      procps \
	      bash \
	      ethtool \
	      iputils \
	      usbutils \
	      dosfstools \
	      mtools \
	      watchdog \
	      v86d \
	      swupdate \
	      swupdate-tools \
	      setserial \
	      gzip \
	      bzip2 \
	      elfutils \
	      cpio \
	      sudo \
	      killall \
	      net-tools \
	      tar \
	      xz \
	      sed \
	      findutils \
	      iproute2 \
	      iproute2-devlink \
	      iproute2-genl \
	      iproute2-ifstat \
	      iproute2-ip \
	      iproute2-lnstat \
	      iproute2-rtacct \
	      iproute2-ss \
	      iproute2-tc \
	      iproute2-tipc \
	      lmsensors \
	      chromium-ozone-wayland \
	      psplash \
	      htop \
	      less \
	      vim \
	      systemd-analyze \
	      "

IMAGE_INSTALL:remove = " nfs-utils \
		         libnfsidmap \
		       "
