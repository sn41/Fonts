package kz.misal.fonts

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.misal.fonts.ui.text.font.MyGoogleFontFamily

@Composable
fun DifferentFonts(modifier: Modifier = Modifier){
    //
    Column(modifier) {
        // Использует стиль по умолчанию (bodyLarge), где у вас прописан myFontFamily
        Text("Google шрифты \"Lobster Two\"")

        Spacer(Modifier.height(8.dp))

        // bodyLarge по умолчанию
        Text("Текст из темы (MyTypography) ")

        // Явно указано fontFamily
        Text("Шрифт \"Lobster Two\" ", fontFamily = MyGoogleFontFamily)

        // Через стиль MaterialTheme (приписано в Type)
        Text("Стиль headlineMedium", style = MaterialTheme.typography.headlineMedium)

        Text("Стиль bodyMedium", style = MaterialTheme.typography.bodyMedium)

        Text("Стиль bodyLarge", style = MaterialTheme.typography.bodyLarge)

        HorizontalDivider()

        Text("Шрифт включённый в apk  \"Marsk_Script\"")

        Spacer(Modifier.height(8.dp))

        Text("Стиль titleLarge ", style = MaterialTheme.typography.titleLarge)

        Text("Стиль labelSmall", style = MaterialTheme.typography.labelSmall)

        HorizontalDivider()

        Text("Это стандартный шрифт FontFamily.Serif, он явно указан - не \"Lobster Two\"", fontFamily = FontFamily.Serif)

        Text("Это стандартный шрифтр FontFamily.SansSerif, он явно указан - не \"Lobster Two\"", fontFamily = FontFamily.SansSerif)

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 32.dp).border(1.dp, Color.Blue, ),
            horizontalArrangement = Arrangement.SpaceBetween) {
            // Весь этот блок будет "стоять" на базовой линии текста внутри него
            Text("BodyLarge", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.alignByBaseline())
            Text("LabelSmall", style = MaterialTheme.typography.labelSmall, modifier = Modifier.alignByBaseline())
            Text("FontFamily.Serif", fontFamily = FontFamily.Serif, modifier = Modifier.alignByBaseline())

        }
    }
}

@Preview
@Composable
fun DifferentFontsPreview(){
    DifferentFonts()
}