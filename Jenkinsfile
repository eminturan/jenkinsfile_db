pipeline
{
    agent none

    stages
    {
        stage('First Stage')
        {
            steps
            {
                script
                {
                    def info_mail = load "db_mail.groovy"
                    info_mail.connect();
                }
            }
        }
    }
}
