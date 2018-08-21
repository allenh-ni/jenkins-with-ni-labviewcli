def call(lvproject_path, target_name, buildspec_name, lv_exe_filepath, lv_portnumber){
//Builds an application, a library, or a bitfile using the settings in the specified build specification(s) and returns the path of the output files.

//lvproject_path - Path to the LabVIEW project (.lvproj) file that contains the build specification.
//target_name - Target that contains the build specification.
//buildspec_name - Name of the build specification that appears under Build Specifications in the Project Explorer window.
//lv_exe_filepath - Specifies the LabVIEW version to use to run the operation.  This argument is required on macOS and Linux but optional on Windows.  If this argument is left blank ("") on Windows, the LabVIEWCLI will use the most recent version of LabVIEW used on the machine.
//lv_portnumber - Specifies the port of the VI server (Tools»Options»VI Server»TCP/IP). If this argument is left blank (""), this command will default to 3363.

        echo 'Executing the \"${buildspec_name}\" build specification in \"${lvproject_path}\"...'
        bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName ExecuteBuildSpec -ProjectPath \"${lvproject_path}\" -TargetName \"${target_name}\" -BuildSpecName \"${buildspec_name}\""
}
