SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

python do_build() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

do_install() {
        bbwarn "Show access to global GVAR : ${GVAR}"
        echo "GVAR : ${GVAR}"
}

python do_myvar_py() {
        bb.warn(' PYTHON GVAR: %s ' % (d.getVar('GVAR', True) or "TEST"))
        print (' PYTHON GVAR: ' + (d.getVar('GVAR', True) or "TEST"))
}
addtask myvar_py before do_build
do_package_write_rpm[noexec] = "1"
do_install[nostamp] = "1"
