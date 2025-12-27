pipeline {
    agent any

    stages {
        // HOCANIN 1. MADDESİ: Kod çekme (Jenkins bunu otomatik yapar ama stage olarak da koyabilirsin)
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        // HOCANIN 2. MADDESİ: Kodlar Build Edilecek (5 Puan)
        stage('Backend Build') {
            steps {
                dir('backend') {
                    sh 'chmod +x mvnw'
                    // -DskipTests diyerek testleri burada çalıştırmıyoruz, sadece derliyoruz.
                    sh './mvnw clean package -DskipTests'
                }
            }
        }

        // HOCANIN 3. ve 4. MADDESİ: Birim ve Entegrasyon Testleri (15 + 15 Puan)
        stage('Backend Tests') {
            steps {
                dir('backend') {
                    // Testleri burada çalıştırıyoruz ve rapor üretiyoruz
                    sh './mvnw test'
                }
            }
            // Test sonuçlarını Jenkins arayüzünde görmek için (Opsiyonel ama şık durur)
            post {
                always {
                    junit 'backend/target/surefire-reports/*.xml'
                }
            }
        }
        
        // Frontend testlerini şimdilik sildik/yorum satırına aldık.
    }
}