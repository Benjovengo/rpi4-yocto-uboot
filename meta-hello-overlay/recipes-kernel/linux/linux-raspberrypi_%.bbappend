# meta-hello-overlay/recipes-kernel/linux/linux-raspberrypi_%.bbappend

# Tell BitBake where to find hello-led-overlay.dts
# THISDIR = .../recipes-kernel/linux
# We want: .../recipes-kernel/dt-overlays/files
FILESEXTRAPATHS:prepend := "${THISDIR}/../dt-overlays/files:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Copy our overlay DTS into the kernel source tree
# S is usually ${WORKDIR}/git for linux-raspberrypi
SRC_URI:append = " \
    file://hello-led-overlay.dts;subdir=git/arch/arm/boot/dts/overlays \
"

# Tell the kernel to build + deploy the DTBO
KERNEL_DEVICETREE:append = " overlays/hello-led.dtbo"
