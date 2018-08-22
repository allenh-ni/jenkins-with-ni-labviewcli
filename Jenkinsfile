#!/usr/bin/env groovy
//Leave the above line alone.  It identifies this as a groovy script.

node{
	String lv_exe_filepath = "C:\\Program Files (x86)\\National Instruments\\LabVIEW 2014\\labview.exe"
	String lv_portnumber = '3363'
	
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
	stage('Build PPL')
	{
		echo "Executing the \"${buildspec_name}\" build specification in ${buildspec_lvprojectpath}..."
		bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName ExecuteBuildSpec -ProjectPath \"${buildspec_lvprojectpath}\" -TargetName \"${buildspec_targetname}\" -BuildSpecName \"${buildspec_name}\""
	}
	
	String buildspec_lvprojectpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\MyCalculator.lvproj"
	String buildspec_targetname = "My Computer"
	String buildspec_name = "My Application"
	stage('Build EXE')
	{
		echo "Executing the \"${buildspec_name}\" build specification in ${buildspec_lvprojectpath}..."
		bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName ExecuteBuildSpec -ProjectPath \"${buildspec_lvprojectpath}\" -TargetName \"${buildspec_targetname}\" -BuildSpecName \"${buildspec_name}\""
	}

	
	//stage('Execute_Build_Spec'){
		//echo 'Executing the build spec...'
		//bat 'LabVIEWCLI -OperationName ExecuteBuildSpec -ProjectPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Example.lvproj\"'
		//nicli-executebuildspec(env.WORKSPACE+'\\sample source\\MyCalculator.lvproj', 'My Computer', 'My Application', lv_exe_filepath, 3363)
		//nicli-executebuildspec(lvproject_path, target_name, buildspec_name, lv_exe_filepath, lv_portnumber)
	//}
	
	//stage('Mass_Compile_VI_Project') {
	//	echo 'Starting mass-compile...'
	//	bat 'LabVIEWCLI -OperationName MassCompile -DirectoryToCompile \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\"'
	//	nicli-masscompile()
	//}
	
	//stage ('RunVI'){
	//	echo 'Running VI...'
	//	bat 'LabVIEWCLI -OperationName RunVI -VIPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Add.vi\" 1 2'
	//}
}