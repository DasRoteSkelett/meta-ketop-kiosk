DESCRIPTION = "Debug image for Keba Ketop "

require core-image-ketop.inc

IMAGE_FEATURES += " ssh-server-openssh package-management debug-tweaks dev-pkgs tools-debug  "

IMAGE_OVERHEAD_FACTOR = "1.4"

IMAGE_INSTALL += "packagegroup-core-buildessential \
	          pciutils \
	          stress \
		  git \
		  netcat-openbsd \
		  less \
		  pstree \
		  cmake \
		  iotop \
		  htop \
		  joe \
		  lsof \
		  parted \
		  sysbench \
		  kernel-devsrc \
		  strace \
		  iperf2 \
		  iperf3 \
		  dmidecode \		  
		  lmsensors-sensorsdetect \
		  lmsensors-sensors \
		  "