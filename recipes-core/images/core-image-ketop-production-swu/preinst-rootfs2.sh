#!/bin/bash

if [[ ! -f /boot/EFI/BOOT/grubenv ]]; then
    grub-editenv /boot/EFI/BOOT/grubenv create 2> /dev/null
fi

umount /dev/disk/by-partlabel/rootfs2 2> /dev/null || /bin/true

