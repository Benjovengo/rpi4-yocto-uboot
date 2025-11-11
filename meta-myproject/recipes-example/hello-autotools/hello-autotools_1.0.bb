SUMMARY = "Autotools-based Hello World program with patching example"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9406189096e519fad52a58bca6b37a17"

# Use a public or local Git repository (example below uses GitHub)
SRC_URI = "git://github.com/Benjovengo/hello-yocto.git;branch=applying-patches;protocol=https \
           file://hello.patch"
SRCREV = "0950b2f302371c98d6d8aed80ca0472465784e5c"

S = "${WORKDIR}/git"

inherit autotools

do_patch:append() {
    bb.note("Patch applied successfully.")
}

# Optionally override any task if needed
do_configure:append() {
    bbnote "Custom configuration step complete."
}

