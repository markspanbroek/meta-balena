FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
SRC_URI_append = "file://docker.cfg \
                "
KERNEL_CONFIG_FRAGMENTS_append = " \
				${WORKDIR}/docker.cfg \
				"
