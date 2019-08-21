def logInfo(args){
    echo "inside jenkinslib info call"
    def JAVAVERSION=sh label: '', returnStdout: true, script: 'which java'
    echo "${JAVAVERSION}"
    echo "${args}"
}

def checkOutsource(giturl,branchname){
    try{
        git url:"${giturl}", branch: "${branchname}"
    }
    catch(err){
        echo "caught exception in checkout src"
    }
    finally{
        echo "finished checkout step"
    }

}

def processArtifacts(archieve,targetpath){
    echo "archiving artifacts"
    echo "${env.JOB_NAME}"
    echo "${env.WORKSPACE}"
    sh "tar -czf ${archieve}.tar.gz ./${targetpath}/*"
    archiveArtifacts "*.gz"
    fingerprint "${archieve}.tar.gz"

}