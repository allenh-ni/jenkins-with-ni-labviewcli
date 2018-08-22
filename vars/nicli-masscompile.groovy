def call(directory_to_compile, lv_exe_filepath, lv_portnumber){
//Mass compiles the files in the specified directory.

//directory_to_compile - folderpath of the VIs to compile.
//lv_exe_filepath - Specifies the LabVIEW version to use to run the operation.  This argument is required on macOS and Linux but optional on Windows.  If this argument is left blank ("") on Windows, the LabVIEWCLI will use the most recent version of LabVIEW used on the machine.
//lv_portnumber - Specifies the port of the VI server (Tools»Options»VI Server»TCP/IP). If this argument is left blank (""), this command will default to 3363.

        echo "Mass-compiling the VIs in \"${directory_to_compile}\"..."
        bat "LabVIEWCLI -OperationName MassCompile -DirectoryToCompile \"${directory_to_compile}\""
}
