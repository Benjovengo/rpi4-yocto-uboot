# meta-hello-overlay/recipes-core/images/core-image-minimal.bbappend

# Ensure the sdcard_image-rpi class knows to include the overlay DTBO
KERNEL_DEVICETREE:append = " overlays/hello-led.dtbo"
