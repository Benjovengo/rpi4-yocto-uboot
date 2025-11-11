SUMMARY = "Example installing two files to different directories"
DESCRIPTION = "Installs hello.txt to /usr/bin and hello2.txt to /home/root"
LICENSE = "CLOSED"
SRC_URI = " \
    file://hello.txt \
    file://hello2.txt \
"

S = "${WORKDIR}"

do_install() {
    # 1. Install hello.txt to /usr/bin
    install -d ${D}${bindir}
    install -m 0644 ${WORKDIR}/hello.txt ${D}${bindir}/hello.txt

    # 2. Install hello2.txt to /home/root
    install -d ${D}/home/root
    install -m 0644 ${WORKDIR}/hello2.txt ${D}/home/root/hello2.txt
}

# Ensure both files are included in the main package
FILES:${PN} += "/home/root/hello2.txt"

inherit allarch
