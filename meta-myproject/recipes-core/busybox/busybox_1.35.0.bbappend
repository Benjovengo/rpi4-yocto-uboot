# Extend BusyBox recipe to install a custom init script

# Add our local files directory to the search path
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Include our new file in the recipe sources
SRC_URI += "file://busybox-init.sh"

# Append to the default install task
do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/busybox-init.sh ${D}${sysconfdir}/init.d/busybox-init
}