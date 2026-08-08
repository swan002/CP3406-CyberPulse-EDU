package au.edu.jcu.cyberpulseedu.data.repository

import au.edu.jcu.cyberpulseedu.domain.model.Lesson
import au.edu.jcu.cyberpulseedu.domain.model.LessonDifficulty

object LessonRepository {

    private val lessons = listOf(

        Lesson(
            id = 1,
            title = "Password Security",
            category = "Account Security",
            summary = "Learn how strong and unique passwords protect your online accounts.",
            content = """
                Passwords are one of the most common methods used to protect online accounts. 
                A weak or reused password can make several accounts vulnerable if attackers 
                successfully obtain the password from one service.

                Strong passwords should be long, difficult to predict, and different for every 
                important account. Instead of trying to remember many complex passwords, users 
                can use a trusted password manager to generate and securely store unique passwords.

                Multi-factor authentication provides another layer of protection. Even if an 
                attacker obtains a password, they may still be unable to access the account without 
                the additional authentication factor.

                Password security is therefore not only about making a password difficult to guess. 
                It also involves avoiding password reuse, protecting credentials, and enabling 
                additional authentication where possible.
            """.trimIndent(),
            securityTips = listOf(
                "Use a different password for every important account.",
                "Prefer long passwords or passphrases.",
                "Use a trusted password manager.",
                "Enable multi-factor authentication whenever possible.",
                "Never share passwords through email or messaging services."
            ),
            difficulty = LessonDifficulty.BEGINNER,
            estimatedMinutes = 4
        ),

        Lesson(
            id = 2,
            title = "Phishing Awareness",
            category = "Social Engineering",
            summary = "Learn to recognise suspicious emails, links, websites, and messages.",
            content = """
                Phishing is a form of social engineering where attackers attempt to trick users 
                into revealing information such as passwords, banking details, or authentication 
                codes.

                Phishing messages often create urgency. For example, an email might claim that an 
                account will be suspended unless the user signs in immediately. Attackers may also 
                imitate trusted organisations, universities, banks, or technology companies.

                Users should examine the sender address, spelling, links, attachments, and the reason 
                for the request before taking action. A message that looks professional can still be 
                malicious.

                Instead of opening a suspicious link, users should visit the organisation's official 
                website directly or contact the organisation through a trusted communication channel.
            """.trimIndent(),
            securityTips = listOf(
                "Check the complete sender address.",
                "Be suspicious of unexpected urgency.",
                "Do not open unexpected attachments.",
                "Verify important requests through an official channel.",
                "Navigate directly to official websites instead of using suspicious links."
            ),
            difficulty = LessonDifficulty.BEGINNER,
            estimatedMinutes = 5
        ),

        Lesson(
            id = 3,
            title = "Social Engineering",
            category = "Human Security",
            summary = "Understand how attackers manipulate people instead of attacking technology directly.",
            content = """
                Social engineering attacks use psychological manipulation to persuade people to 
                perform actions that benefit an attacker.

                Attackers may pretend to be managers, technical support staff, delivery personnel, 
                lecturers, colleagues, or other trusted individuals. Common techniques include 
                impersonation, pretexting, authority pressure, fear, curiosity, and urgency.

                A technically secure system can still be compromised if someone is convinced to 
                reveal confidential information or approve an unsafe request.

                Users should therefore verify unusual requests, especially when they involve 
                passwords, confidential information, financial transactions, or changes to security 
                settings.
            """.trimIndent(),
            securityTips = listOf(
                "Verify unusual requests before acting.",
                "Do not assume authority automatically means legitimacy.",
                "Never disclose authentication codes to another person.",
                "Be cautious when someone creates artificial urgency.",
                "Report suspicious behaviour through the correct organisational channel."
            ),
            difficulty = LessonDifficulty.INTERMEDIATE,
            estimatedMinutes = 5
        ),

        Lesson(
            id = 4,
            title = "Malware & Ransomware",
            category = "Malware",
            summary = "Learn how malicious software spreads and how common infections can be prevented.",
            content = """
                Malware is software intentionally designed to damage systems, steal information, 
                monitor users, or provide attackers with unauthorised access.

                Malware can spread through malicious attachments, compromised websites, infected 
                software, removable devices, and software vulnerabilities.

                Ransomware is a type of malware that can encrypt files or prevent users from accessing 
                systems. Attackers commonly demand payment in exchange for restoring access.

                Prevention includes keeping software updated, avoiding suspicious downloads, using 
                appropriate security controls, and maintaining reliable backups of important data.
            """.trimIndent(),
            securityTips = listOf(
                "Keep operating systems and applications updated.",
                "Avoid downloading software from unknown sources.",
                "Do not open suspicious email attachments.",
                "Maintain backups of important information.",
                "Report suspicious system behaviour quickly."
            ),
            difficulty = LessonDifficulty.INTERMEDIATE,
            estimatedMinutes = 5
        ),

        Lesson(
            id = 5,
            title = "Public Wi-Fi Safety",
            category = "Network Security",
            summary = "Understand the risks of public wireless networks and safer ways to connect.",
            content = """
                Public Wi-Fi is convenient, but users often have limited information about who 
                operates the network and whether it is properly secured.

                Attackers may create wireless networks with names similar to legitimate networks. 
                A user who connects to the wrong network could expose information or be redirected 
                to malicious websites.

                Sensitive activities should be avoided on networks that cannot be trusted. Users 
                should verify network names, prefer encrypted HTTPS connections, and disable automatic 
                connection to unknown networks.

                When possible, a trusted mobile connection may be safer for sensitive activities.
            """.trimIndent(),
            securityTips = listOf(
                "Confirm the correct Wi-Fi network name.",
                "Avoid sensitive transactions on unknown networks.",
                "Look for HTTPS when accessing websites.",
                "Disable automatic connection to unknown Wi-Fi networks.",
                "Use trusted network connections for important accounts."
            ),
            difficulty = LessonDifficulty.BEGINNER,
            estimatedMinutes = 4
        ),

        Lesson(
            id = 6,
            title = "Multi-Factor Authentication",
            category = "Account Security",
            summary = "Learn why additional authentication factors make accounts harder to compromise.",
            content = """
                Multi-factor authentication, commonly called MFA, requires more than one type of 
                evidence before a user can access an account.

                Authentication factors usually fall into categories such as something you know, 
                something you have, or something you are.

                MFA significantly improves account protection because stealing a password alone may 
                not be enough to access the account.

                However, attackers may attempt MFA fatigue attacks by repeatedly sending authentication 
                requests and hoping that the user eventually approves one. Users should reject 
                unexpected authentication requests and investigate why they occurred.
            """.trimIndent(),
            securityTips = listOf(
                "Enable MFA on important accounts.",
                "Never approve an authentication request you did not initiate.",
                "Protect backup authentication codes.",
                "Prefer authenticator apps or stronger authentication methods where available.",
                "Report repeated unexpected authentication requests."
            ),
            difficulty = LessonDifficulty.INTERMEDIATE,
            estimatedMinutes = 4
        ),

        Lesson(
            id = 7,
            title = "Data Privacy",
            category = "Privacy",
            summary = "Learn how personal information is collected and how unnecessary exposure can be reduced.",
            content = """
                Personal information can include names, contact details, account information, location 
                data, photographs, identifiers, and behavioural information.

                Applications should collect only the information required to provide their intended 
                functionality. This principle is often described as data minimisation.

                Users should review application permissions and consider whether the requested access 
                is necessary. For example, an application that does not use location-based features 
                may not need access to precise location information.

                Privacy also involves thinking carefully about information shared publicly because 
                seemingly harmless pieces of information can sometimes be combined to reveal more 
                about a person.
            """.trimIndent(),
            securityTips = listOf(
                "Review app permissions regularly.",
                "Share only information that is necessary.",
                "Check privacy settings on important accounts.",
                "Be careful when sharing location information.",
                "Remove permissions that an application no longer needs."
            ),
            difficulty = LessonDifficulty.INTERMEDIATE,
            estimatedMinutes = 5
        ),

        Lesson(
            id = 8,
            title = "Secure Browsing",
            category = "Web Security",
            summary = "Learn safer habits for browsing websites, installing extensions, and downloading files.",
            content = """
                Web browsers are frequently used to access sensitive accounts, download files, and 
                interact with online services.

                Keeping the browser updated is important because updates often fix security 
                vulnerabilities. Users should also be cautious when installing browser extensions, 
                because extensions may request permission to access browsing information or modify 
                website content.

                HTTPS protects communication between the browser and a website, although HTTPS alone 
                does not guarantee that a website is trustworthy.

                Suspicious advertisements, unexpected downloads, fake update messages, and unfamiliar 
                websites should be treated carefully.
            """.trimIndent(),
            securityTips = listOf(
                "Keep your browser updated.",
                "Install extensions only from trusted sources.",
                "Review extension permissions.",
                "Avoid unexpected downloads and fake update messages.",
                "Check website addresses before entering sensitive information."
            ),
            difficulty = LessonDifficulty.BEGINNER,
            estimatedMinutes = 4
        )
    )

    fun getLessons(): List<Lesson> {
        return lessons
    }

    fun getLessonById(id: Int): Lesson? {
        return lessons.find { lesson ->
            lesson.id == id
        }
    }
}