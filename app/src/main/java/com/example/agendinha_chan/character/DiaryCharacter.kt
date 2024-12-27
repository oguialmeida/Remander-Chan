package com.example.agendinha_chan.character

import com.example.agendinha_chan.data.Mood

class DiaryCharacter {
    companion object {
        fun getGreeting(hour: Int): String = when (hour) {
            in 5..11 -> "Ohayou! Ready to write about your morning? ☀️"
            in 12..17 -> "Konnichiwa! How's your day going? 🌸"
            in 18..22 -> "Konbanwa! Let's reflect on your day! 🌙"
            else -> "Ara ara~ Still awake? Let's write together! ✨"
        }

        fun getMoodResponse(mood: Mood): String = when (mood) {
            Mood.VERY_HAPPY -> "Waaai! I'm so happy to see you in such great spirits! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧"
            Mood.HAPPY -> "Your happiness makes me smile too! (◕‿◕✿)"
            Mood.NEUTRAL -> "Remember, I'm always here to listen! Want to share more? (｡◕‿◕｡)"
            Mood.SAD -> "Daijoubu! Tomorrow will be better. Let me give you a virtual hug! (っ´▽｀)っ"
            Mood.VERY_SAD -> "I'll stay by your side until you feel better. You're not alone! (づ｡◕‿‿◕｡)づ"
        }

        fun getEncouragement(): String {
            val encouragements = listOf(
                "Ganbare! You can do it! ٩(◕‿◕｡)۶",
                "You're doing amazing! Keep going! ★~(◡﹏◕✿)",
                "Remember to take care of yourself today! (｡♥‿♥｡)",
                "Your diary entries always brighten my day! (◠‿◠✿)",
                "Let's make more wonderful memories together! ⭐"
            )
            return encouragements.random()
        }

        fun getWritingPrompt(): String {
            val prompts = listOf(
                "What made you smile today? (´｡• ᵕ •｡`)",
                "Did you try anything new? Tell me about it! (◕‿◕✿)",
                "What are you looking forward to? ✨",
                "Who made your day special? (｡◕‿◕｡)",
                "What's your biggest dream right now? 🌟"
            )
            return prompts.random()
        }
    }
}
