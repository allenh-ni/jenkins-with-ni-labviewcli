def call(lvproject_path, junit_reportpath, lv_exe_filepath, lv_portnumber){
//Runs tests on the specified files in the LabVIEW Unit Test Framework Toolkit and saves the JUnit file to the specified location.
//Note: To run this operation, you must install the UTF Junit Report library using the JKI VI Package Manager (VIPM) software. 

//lvproject_path - Path to the LabVIEW project file (.lvproj) containing the UTF tests.
//junit_reportpath - Path to the output JUnit file.
//lv_exe_filepath - Specifies the LabVIEW version to use to run the operation.  This argument is required on macOS and Linux but optional on Windows.  If this argument is left blank ("") on Windows, the LabVIEWCLI will use the most recent version of LabVIEW used on the machine.
//lv_portnumber - Specifies the port of the VI server (Tools»Options»VI Server»TCP/IP). If this argument is left blank (""), this command will default to 3363.

        echo 'Running LabVIEW Unit Test Framework Toolkit tests in \"${lvproject_path}\"...'
        bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName RunUnitTests -ProjectPath \"${lvproject_path}\" -JUnitReportPath \"${junit_reportpath}\" -LabVIEWPath \"${lv_exe_filepath}\""
}
