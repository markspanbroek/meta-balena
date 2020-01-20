DESCRIPTION = "Small image capable of booting a device. The kernel includes \
the Minimal RAM-based Initial Root Filesystem (initramfs), which finds the \
first 'init' program more efficiently. This is used to prepare the rootfs \
with some key operations."

PACKAGE_INSTALL = " \
    base-passwd \
    busybox \
    initramfs-module-debug \
    initramfs-module-prepare \
    initramfs-module-fsck \
    initramfs-module-machineid \
    initramfs-module-resindataexpander \
    initramfs-module-rorootfs \
    initramfs-module-udev \
    initramfs-framework-base \
    udev \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
    "

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "resin-image-initramfs"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
IMAGE_ROOTFS_MAXSIZE_remove = "12288"
IMAGE_ROOTFS_MAXSIZE_remove = "12300"
IMAGE_ROOTFS_MAXSIZE_remove = "16384"

python __anonymous() {
    if d.getVar('IMAGE_ROOTFS_MAXSIZE') == '':
        d.setVar('IMAGE_ROOTFS_MAXSIZE', '16384')
}

BAD_RECOMMENDATIONS += "busybox-syslog"
