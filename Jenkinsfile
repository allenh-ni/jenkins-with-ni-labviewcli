#!/usr/bin/env groovy
//Leave the above line alone.  It identifies this as a groovy script.

node{
	//lv_exe_filepath - Specifies the LabVIEW version to use to run the operation.  This argument is required on macOS and Linux but optional on Windows.  If this argument is left blank ("") on Windows, the LabVIEWCLI will use the most recent version of LabVIEW used on the machine.
	//lv_portnumber - Specifies the port of the VI server (Tools»Options»VI Server»TCP/IP). If this argument is left blank (""), this command will default to 3363.
	String lv_exe_filepath = "C:\\Program Files (x86)\\National Instruments\\LabVIEW 2015\\labview.exe"
	String lv_portnumber = '3364'
	
	echo 'Starting build...'
	
	stage ('Pre-Clean'){
		echo 'Starting Pre-Clean stage...'
		preClean()
	}
	
	stage ('SCM_Checkout'){
		echo 'Attempting to get source from repo...'
		timeout(time: 5, unit: 'MINUTES'){
			checkout scm
		}
	}
	
	String DirectoryToCompile = "${WORKSPACE}\\sample source"
	stage('Mass_Compile_VI_Project') {
		echo "Starting mass-compile of \"${WORKSPACE}\\sample source\"..."
		bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName MassCompile -DirectoryToCompile \"${DirectoryToCompile}\""
	}
	
	String via_configpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\VI Analyzer tests\\VI Analyzer Test.cfg"
	String via_reportsavetype = 'ASCII'
	String via_reportpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\VI Analyzer results.txt"
	stage ('Run VI Analyzer tests'){
		echo "Running VI Analyzer task - \"${via_configpath}\"..."
        bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName RunVIAnalyzer -ConfigPath \"${via_configpath}\" -ReportPath \"${via_reportpath}\" -ReportSaveType \"${via_reportsavetype}\""
	}
	
	String utf_lvprojectpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\MyCalculator.lvproj"
	String utf_junitreportpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\UTF results.xml"
	stage ('Run UTF unit tests'){
		echo "Running UTF unit tests on ${utf_lvprojectpath}..."
		bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName RunUnitTests -ProjectPath \"${utf_lvprojectpath}\" -JUnitReportPath \"${utf_junitreportpath}\" -LabVIEWPath \"${lv_exe_filepath}\""
	}
	
	String buildspec_lvprojectpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\MyCalculator.lvproj"
	String buildspec_targetname = "My Computer"
	String buildspec_name = "My Packed Library"
	stage('Build PPL'){
		echo "Executing the \"${buildspec_name}\" build specification in ${buildspec_lvprojectpath}..."
		bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName ExecuteBuildSpec -ProjectPath \"${buildspec_lvprojectpath}\" -TargetName \"${buildspec_targetname}\" -BuildSpecName \"${buildspec_name}\""
	}
	
	//The following variables have already been previously declared.  Updating their values now.
	buildspec_lvprojectpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\MyCalculator.lvproj"
	buildspec_targetname = "My Computer"
	buildspec_name = "My Application"
	stage('Build EXE'){
		echo "Executing the \"${buildspec_name}\" build specification in ${buildspec_lvprojectpath}..."
		bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName ExecuteBuildSpec -ProjectPath \"${buildspec_lvprojectpath}\" -TargetName \"${buildspec_targetname}\" -BuildSpecName \"${buildspec_name}\""
	}

	//String vipbBuild_vipath = "C:\\Users\\Public\\Documents\\National Instruments\\LabVIEW CLI\\CI Steps\\nicli_vipbBuild.vi"
	String vipbBuild_VIPBPath = "${WORKSPACE}\\sample source\\acme_math.vipb"
	stage('Build VIPM package'){
		echo "Executing VIPM build specification \"${vipbBuild_VIPBPath}\" to create a VIPM package..."
		bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName BuildVIPMPackage -VIPBPath \"${vipbBuild_VIPBPath}\""
		//Note: You must install the add-on files for the BuildVIPMPackage CLI Operation.
	}
	
	//stage ('RunVI'){
	//	echo 'Running VI...'
	//	bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName RunVI -VIPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Add.vi\" 1 2"
	//}
}