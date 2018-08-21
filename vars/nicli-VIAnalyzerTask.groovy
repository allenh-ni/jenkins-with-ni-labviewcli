def call(via_configpath, via_reportpath, reportsavetype, lv_exe_filepath, lv_portnumber){
//via_configpath - Path to the configuration file (.viacfg) that contains VI Analyzer task settings to use in the analysis. You can use a configuration file you saved through the VI Analyzer or the VI Analyzer VIs. Alternatively, you can specify a VI, folder, or LLB to analyze. If you specify an item other than a configuration file, the VI runs all VI Analyzer tests on the specified item.
//via_reportpath - Path to the report or results file.
//via_reportsavetype - Format of the report or results file.  The value for this argument must be one of the following: "ASCII", "HTML", "RSL File" 
//lv_exe_filepath - Specifies the LabVIEW version to use to run the operation.  This argument is required on macOS and Linux but optional on Windows.  If this argument is left blank ("") on Windows, the LabVIEWCLI will use the most recent version of LabVIEW used on the machine.
//lv_portnumber - Specifies the port of the VI server (Tools»Options»VI Server»TCP/IP). If this argument is left blank (""), this command will default to 3363.

        echo 'Running VI Analyzer task - \"${via_configpath}\"...'
        bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName RunVIAnalyzer -ConfigPath \"${via_configpath}\" -ReportPath \"${via_reportpath}\" -ReportSaveType \"${via_reportsavetype}\""
}
