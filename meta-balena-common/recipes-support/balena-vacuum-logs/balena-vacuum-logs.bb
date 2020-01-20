DESCRIPTION = "Periodic vacuum of log files"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${RESIN_COREBASE}/COPYING.Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
    file://balena-vacuum-logs.timer \
    file://balena-vacuum-logs.service \
    "

inherit allarch systemd

SYSTEMD_SERVICE_${PN} = " \
    balena-vacuum-logs.service \
    balena-vacuum-logs.timer \
"

do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_build[noexec] = "1"

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system/
        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        install -m 0644 ${WORKDIR}/balena-vacuum-logs.service ${D}${systemd_unitdir}/system/
        install -m 0644 ${WORKDIR}/balena-vacuum-logs.timer ${D}${systemd_unitdir}/system/
    fi
}
