package au.edu.jcu.cyberpulseedu.data.repository

import au.edu.jcu.cyberpulseedu.domain.model.LessonDifficulty
import au.edu.jcu.cyberpulseedu.domain.model.QuizQuestion

object QuizRepository {

    private val questions = listOf(

        QuizQuestion(
            id = 1,
            topic = "Password Security",
            difficulty = LessonDifficulty.BEGINNER,
            question = "Which password practice provides the strongest protection?",
            options = listOf(
                "Reuse one complicated password everywhere",
                "Use a unique password for each important account",
                "Change one character when reusing passwords",
                "Store passwords in an unprotected notes file"
            ),
            correctAnswerIndex = 1,
            explanation = "Using a unique password for every important account reduces the impact of credential theft. If one service is compromised, attackers cannot automatically reuse the same password elsewhere."
        ),

        QuizQuestion(
            id = 2,
            topic = "Password Security",
            difficulty = LessonDifficulty.BEGINNER,
            question = "Why is multi-factor authentication useful?",
            options = listOf(
                "It makes usernames unnecessary",
                "It automatically changes passwords every day",
                "It adds another verification step beyond the password",
                "It prevents all types of cyberattacks"
            ),
            correctAnswerIndex = 2,
            explanation = "Multi-factor authentication adds another verification factor, so stealing a password alone may not be enough for an attacker to access the account."
        ),

        QuizQuestion(
            id = 3,
            topic = "Phishing Awareness",
            difficulty = LessonDifficulty.BEGINNER,
            question = "You receive an email saying your university account will be closed in 30 minutes unless you sign in through a link. What should you do?",
            options = listOf(
                "Click the link immediately",
                "Reply with your password",
                "Open the official university website separately and verify the message",
                "Forward the email to friends"
            ),
            correctAnswerIndex = 2,
            explanation = "Urgency is a common phishing technique. Instead of using the link in the message, access the organisation through a trusted website or another verified communication channel."
        ),

        QuizQuestion(
            id = 4,
            topic = "Phishing Awareness",
            difficulty = LessonDifficulty.INTERMEDIATE,
            question = "Which sign most strongly suggests that an email may be phishing?",
            options = listOf(
                "The email contains the organisation's logo",
                "The sender address uses an unfamiliar domain",
                "The email uses professional language",
                "The message contains your first name"
            ),
            correctAnswerIndex = 1,
            explanation = "Attackers can copy logos, names and professional formatting. An unusual or misleading sender domain can reveal that the message is not from the legitimate organisation."
        ),

        QuizQuestion(
            id = 5,
            topic = "Social Engineering",
            difficulty = LessonDifficulty.INTERMEDIATE,
            question = "Someone claiming to be technical support calls and urgently asks for your MFA code. What is the safest response?",
            options = listOf(
                "Give them the code because they are technical support",
                "Ask them to call again later",
                "Refuse and verify the request through an official support channel",
                "Send the code by email instead"
            ),
            correctAnswerIndex = 2,
            explanation = "Authentication codes should not be shared. Verify unexpected requests independently using official contact information."
        ),

        QuizQuestion(
            id = 6,
            topic = "Malware & Ransomware",
            difficulty = LessonDifficulty.INTERMEDIATE,
            question = "Which action best reduces the impact of ransomware?",
            options = listOf(
                "Disable all software updates",
                "Maintain reliable backups of important information",
                "Open unknown attachments to check them",
                "Use the same password across devices"
            ),
            correctAnswerIndex = 1,
            explanation = "Reliable backups can allow data to be restored after a ransomware incident and reduce dependence on attackers."
        ),

        QuizQuestion(
            id = 7,
            topic = "Public Wi-Fi Safety",
            difficulty = LessonDifficulty.BEGINNER,
            question = "You see two Wi-Fi networks with very similar names in a café. What should you do?",
            options = listOf(
                "Connect to whichever has the strongest signal",
                "Verify the official network name before connecting",
                "Connect to both networks",
                "Choose the network without a password"
            ),
            correctAnswerIndex = 1,
            explanation = "Attackers can create fake wireless networks using names similar to legitimate hotspots. Verify the correct network before connecting."
        ),

        QuizQuestion(
            id = 8,
            topic = "Multi-Factor Authentication",
            difficulty = LessonDifficulty.INTERMEDIATE,
            question = "Your phone suddenly receives repeated MFA approval requests that you did not initiate. What should you do?",
            options = listOf(
                "Approve one so the notifications stop",
                "Ignore the requests permanently",
                "Reject them and investigate the account immediately",
                "Disable your screen lock"
            ),
            correctAnswerIndex = 2,
            explanation = "Repeated unexpected MFA requests can indicate an MFA fatigue attack or compromised credentials. Reject the requests and investigate the account."
        ),

        QuizQuestion(
            id = 9,
            topic = "Data Privacy",
            difficulty = LessonDifficulty.INTERMEDIATE,
            question = "A simple study app requests access to your precise location even though it has no location-based features. What is the best response?",
            options = listOf(
                "Allow it because all apps need location",
                "Deny the permission unless the app can justify why it is necessary",
                "Give permanent location access",
                "Turn off your device password"
            ),
            correctAnswerIndex = 1,
            explanation = "Data minimisation means applications should collect only information required for their purpose. Unnecessary permissions should be avoided."
        ),

        QuizQuestion(
            id = 10,
            topic = "Secure Browsing",
            difficulty = LessonDifficulty.BEGINNER,
            question = "Does HTTPS automatically mean that a website is trustworthy?",
            options = listOf(
                "Yes, HTTPS guarantees the website is legitimate",
                "No, HTTPS encrypts the connection but a malicious site can still use HTTPS",
                "Yes, but only on mobile devices",
                "No, because HTTPS provides no security at all"
            ),
            correctAnswerIndex = 1,
            explanation = "HTTPS protects data transmitted between the browser and website, but malicious websites can also use HTTPS. Users must still check the website address and context."
        ),

        QuizQuestion(
            id = 11,
            topic = "Phishing Awareness",
            difficulty = LessonDifficulty.INTERMEDIATE,
            question = "You receive a QR code in an unexpected email asking you to scan it to reset your password. What should you do?",
            options = listOf(
                "Scan it immediately",
                "Verify the request using the organisation's official website",
                "Send the QR code to another person first",
                "Disable your antivirus and scan it"
            ),
            correctAnswerIndex = 1,
            explanation = "QR codes can hide malicious destinations. Verify unexpected password reset requests independently through the organisation's official service."
        ),

        QuizQuestion(
            id = 12,
            topic = "Secure Browsing",
            difficulty = LessonDifficulty.INTERMEDIATE,
            question = "A browser extension asks for permission to read and change data on every website you visit. What should you do?",
            options = listOf(
                "Install it without checking",
                "Review whether the permission is necessary before installing",
                "Disable browser updates",
                "Share the extension with everyone"
            ),
            correctAnswerIndex = 1,
            explanation = "Browser extensions can receive powerful permissions. Users should understand why those permissions are needed and avoid unnecessary access."
        )
    )

    fun getAllQuestions(): List<QuizQuestion> {
        return questions
    }

    fun getQuestions(
        topic: String?,
        difficulty: LessonDifficulty?,
        questionCount: Int
    ): List<QuizQuestion> {

        val filteredQuestions = questions.filter { question ->

            val topicMatches =
                topic == null ||
                        topic == "All Topics" ||
                        question.topic == topic

            val difficultyMatches =
                difficulty == null ||
                        question.difficulty == difficulty

            topicMatches && difficultyMatches
        }

        return filteredQuestions
            .shuffled()
            .take(questionCount)
    }

    fun getTopics(): List<String> {
        return listOf(
            "All Topics",
            "Password Security",
            "Phishing Awareness",
            "Social Engineering",
            "Malware & Ransomware",
            "Public Wi-Fi Safety",
            "Multi-Factor Authentication",
            "Data Privacy",
            "Secure Browsing"
        )
    }
}