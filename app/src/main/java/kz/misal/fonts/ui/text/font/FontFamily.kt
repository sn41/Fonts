package kz.misal.fonts.ui.text.font

// ...
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
//import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import kz.misal.fonts.R


val provider = GoogleFont.Provider(
    //The font provider authority for Google Fonts.
    providerAuthority = "com.google.android.gms.fonts",
    //The font provider package to verify the identity of the provider.
    providerPackage = "com.google.android.gms",
    // Список наборов хешей для сертификатов, используемых для проверки подлинности поставщика.
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Lobster Two")

//val fontFamily = FontFamily(
//    Font(googleFont = fontName, fontProvider = provider)
//)

val MyGoogleFontFamily = FontFamily(
    Font(
        googleFont = fontName,
        fontProvider = provider,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    )

)

val MyCustomFontFamily = FontFamily(
    Font(R.font.marck_script_regular, FontWeight.Normal),
    Font(R.font.marck_script_regular, FontWeight.Bold),
    Font(R.font.marck_script_regular, FontWeight.Normal, FontStyle.Italic)
)