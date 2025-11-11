SUMMARY = "A Hello World C program fetched from a Git repository"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9406189096e519fad52a58bca6b37a17"

# Use a public or local Git repository (example below uses GitHub)
SRC_URI = "git://github.com/Benjovengo/hello-yocto.git;branch=main;protocol=https"
SRCREV = "38edbbc79ff8915483cc86c0a50907252077ed5e"

S = "${WORKDIR}/git"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} hello.c -o hello
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello ${D}${bindir}/hello
}

