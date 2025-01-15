# Resolve issue with udev rules in meta-rockchip layer

FILES_${PN} += "${nonarch_base_libdir}/udev/*"

do_install() {
        install -d ${sysconfdir}/udev/rules.d
        install -m 0644 ${WORKDIR}/99-rockchip-permissions.rules ${D}${sysconfdir}/udev/rules.d/99-rockchip-permissions.rules
}
