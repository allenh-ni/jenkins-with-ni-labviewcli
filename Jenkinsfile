#!/usr/bin/env groovy
//Leave the above line alone.  It identifies this as a groovy script.

node{
	echo 'Starting build...'
//	stage ('Pre-Clean'){
//		echo 'Starting Pre-Clean stage...'
//		preClean()
//	}
	stage ('SCM_Checkout'){
		echo 'Attempting to get source from repo...'
		timeout(time: 5, unit: 'MINUTES'){
			checkout scm
		}
	}
	stage('Mass_Compile_VI_Project') {
		echo 'Starting mass-compile...'
		bat 'LabVIEWCLI -OperationName MassCompile -DirectoryToCompile \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\"'
	}
	stage ('RunVI'){
		echo 'Running VI...'
		bat 'LabVIEWCLI -OperationName RunVI -VIPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Add.vi\" 1 2'
	}
	stage('Execute_Build_Spec'){
		echo 'Executing the build spec...'
		bat 'LabVIEWCLI -OperationName ExecuteBuildSpec -ProjectPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Example.lvproj\"'
	}
}