DESCRIPTION = "Jupyter notebook examples for Power Management (PM) in Versal devices"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=268f2517fdae6d70f4ea4c55c4090aa8"

SRC_URI = "file://LICENSE \
           file://README \
           file://pm-cpufreq.ipynb \
           file://pm-hotplug.ipynb \
           file://pmutil/__init__.py \
           file://pmutil/cpufreq.py \
           file://pmutil/hotplug.py \
           file://pmutil/data/cpu-icon-0-off.png \
           file://pmutil/data/cpu-icon-0-on.png \
           file://pmutil/data/cpu-icon-1-off.png \
           file://pmutil/data/cpu-icon-1-on.png \
           file://pmutil/data/cpu-icon-freq-1.png \
           file://pmutil/data/cpu-icon-freq-2.png \
           file://pmutil/data/cpu-icon-freq-3.png \
           file://pmutil/data/cpu-icon-freq-4.png \
           file://pmutil/data/cpu-icon-freq-def.png \
           "

S = "${WORKDIR}"

FILES_${PN} += "${datadir}"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_versal = "versal"

RDEPENDS_${PN} = "packagegroup-petalinux-jupyter \
                  python3-ipywidgets \
                  "

do_install() {
    install -d ${D}/${datadir}/pm-notebooks
    install -d ${D}/${datadir}/pm-notebooks/pmutil
    install -d ${D}/${datadir}/pm-notebooks/pmutil/data

    install -m 0755 ${S}/*.ipynb ${D}/${datadir}/pm-notebooks
    install -m 0755 ${S}/pmutil/*.py ${D}/${datadir}/pm-notebooks/pmutil
    install -m 0755 ${S}/pmutil/data/*.png ${D}/${datadir}/pm-notebooks/pmutil/data
}

# These libraries shouldn't get installed in world builds unless something
# explicitly depends upon them.

EXCLUDE_FROM_WORLD = "1"