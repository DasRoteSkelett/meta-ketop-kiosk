#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <swu-image-to-install>. Must be root to execute sucessfully. reboots on success!!"
    exit 1
fi


if [[ ! -f /boot/EFI/BOOT/grubenv ]]; then
    swupdate -L -v -e stable,rootfs1 -p /sbin/reboot -i "$1"
    exit 0
fi

PART=$(grub-editenv /boot/EFI/BOOT/grubenv list | grep default | cut --fields=2 --delimiter='=')

echo "Updating from PART \"$PART\""
swupdate -L -v -e stable,"$PART" -p /sbin/reboot -i "$1"



