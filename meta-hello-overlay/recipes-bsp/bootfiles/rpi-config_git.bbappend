FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://config.txt"

do_deploy:append() {
    if ! grep -q "^dtoverlay=hello-led" ${DEPLOYDIR}/config.txt; then
        echo "" >> ${DEPLOYDIR}/config.txt
        echo "# Enable custom hello-led overlay" >> ${DEPLOYDIR}/config.txt
        echo "dtoverlay=hello-led" >> ${DEPLOYDIR}/config.txt
    fi
}
