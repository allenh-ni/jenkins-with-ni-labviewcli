#!/usr/bin/env groovy
//Leave the above line alone.  It identifies this as a groovy script.

node{
	echo 'Starting build...'
	stage ('Pre-Clean'){
		preClean()
	}
	stage ('SCM_Checkout'){
		echo 'Attempting to get source from repo...'
		timeout(time: 5, unit: 'MINUTES'){
			checkout scm
		}
	}
	stage ('RunVI'){
		bat 'LabVIEWCLI -OperationName RunVI -VIPath \"C:\\Program Files (x86)\\Jenkins\\workspace\\Pipeline script from SCM\\source\\NI CLI Add.vi\" 1 2'
	}
}