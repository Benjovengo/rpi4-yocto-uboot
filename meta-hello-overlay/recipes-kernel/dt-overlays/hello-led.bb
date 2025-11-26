SUMMARY = "Hello LED overlay"
DESCRIPTION = "Raspberry Pi LED overlay example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello-led-overlay.dts"

S = "${WORKDIR}"

# FIX: Ensure dtc is available during do_compile
DEPENDS += "dtc-native"

do_compile() {
    ${STAGING_BINDIR_NATIVE}/dtc -@ -I dts -O dtb \
        -o hello-led-overlay.dtbo hello-led-overlay.dts
}

do_install() {
    install -d ${D}/boot/overlays
    install -m 0644 hello-led-overlay.dtbo ${D}/boot/overlays/
}

FILES:${PN} = "/boot/overlays/hello-led-overlay.dtbo"
