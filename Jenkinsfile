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
	
	//stage('Mass_Compile_VI_Project') {
	//	echo 'Starting mass-compile...'
	//	bat 'LabVIEWCLI -OperationName MassCompile -DirectoryToCompile \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\"'
	//	nicli-masscompile()
	//}
	
	//stage ('RunVI'){
	//	echo 'Running VI...'
	//	bat 'LabVIEWCLI -OperationName RunVI -VIPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Add.vi\" 1 2'
	//}
	
	String via_configpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\VI Aanlyzer tests\\VI Analyzer Test.cfg"
	String via_reportpath = "C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\sample source\\VI Aanlyzer tests\\VI Analyzer Test.txt"
	String via_reportsavetype = 'ASCII'
	
	stage ('Run VI Analyzer tests'){
		echo 'Running VI Analyzer task - \"${via_configpath}\"...'
        bat "LabVIEWCLI -LabVIEWPath \"${lv_exe_filepath}\" -PortNumber \"${lv_portnumber}\" -OperationName RunVIAnalyzer -ConfigFilePath \"${via_configpath}\" -ReportPath \"${via_reportpath}\" -ReportSaveType \"${via_reportsavetype}\""
	}
	
	//stage('Execute_Build_Spec'){
		//echo 'Executing the build spec...'
		//bat 'LabVIEWCLI -OperationName ExecuteBuildSpec -ProjectPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Example.lvproj\"'
		//nicli-executebuildspec(env.WORKSPACE+'\\sample source\\MyCalculator.lvproj', 'My Computer', 'My Application', lv_exe_filepath, 3363)
		//nicli-executebuildspec(lvproject_path, target_name, buildspec_name, lv_exe_filepath, lv_portnumber)
	//}
}