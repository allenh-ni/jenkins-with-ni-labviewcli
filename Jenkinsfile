#!/usr/bin/env groovy
//Leave the above line alone.  It identifies this as a groovy script.

node{
	stage ('SCM_Checkout'){
		echo 'Attempting to get source from repo...'
		timeout(time: 5, unit: 'MINUTES'){
			checkout scm
		}
	}
//	stage ('RunVI'){
//		bat 'LabVIEWCLI -OperationName RunVI -VIPath \"<insert VI Path>\ <input 1> <input 2>"'
//	}
}