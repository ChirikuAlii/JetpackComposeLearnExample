package info.chirikualii.examplejetpackcompose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.Shadow
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Divider
import androidx.ui.material.Surface
import androidx.ui.text.SpanStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.annotatedString
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.font.fontFamily
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.text.style.TextIndent
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import androidx.ui.unit.sp

class CustomTextActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerticalScroller {
                Column {

                    composeCustomText(
                            text = "This is the Default text style"
                    )

                    composeCustomText(
                            text = "text with blue color",
                            style = TextStyle(color = Color.Blue)
                    )

                    composeCustomText(
                            text = "This is text with bigger font size",
                            style = TextStyle(fontSize = 24.sp)
                    )

                    composeCustomText(
                            text = "This is text with bold style",
                            style = TextStyle(fontWeight = FontWeight.Bold)
                    )

                    composeCustomText(
                            text = "This is text is italic",
                            style = TextStyle(fontStyle = FontStyle.Italic)
                    )

                    composeCustomText(
                            text = "This text with custom Font Family",
                            style = TextStyle(fontFamily = FontFamily.Cursive)

                    )

                    composeCustomText(
                            text = "This text with underline" ,
                            style = TextStyle(textDecoration = TextDecoration.Underline)
                            )

                    composeCustomText(
                            text = "This text with strikerthrough line",
                            style = TextStyle(textDecoration = TextDecoration.LineThrough)
                            )

                    composeCustomText(
                            text = "This text with ellipsis to the end of text 123123123123213123123123213" ,
                            maxLines = 1
                    )

                    composeCustomText(
                            text = "This text has a shadow",
                            style = TextStyle(
                                    shadow = Shadow(
                                            color = Color.Black, blurRadius = 10f,
                                            offset = Offset(2f,2f)
                                    )
                            )
                     )

                    composeCustomText(
                            text = "This text is center aligned",
                            style = TextStyle(
                                    textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.fillMaxWidth() + Modifier.padding(16.dp)
                    )

                    composeCustomText(
                            text = "This text will demonstrate how to justify " +
                                    "your paragraph to ensure that the text that ends with a soft " +
                                    "line break spreads and takes the entire width of the container",
                            style = TextStyle(
                                    textAlign = TextAlign.Justify
                            )
                    )
                    
                    composeCustomText(
                            text = "This text will demonstrate how to add " +
                                    "indentation to your text. In this example, indentation was only " +
                                    "added to the first line. You also have the option to add " +
                                    "indentation to the rest of the lines if you'd like",
                            style = TextStyle(
                                    textAlign = TextAlign.Justify,
                                    textIndent = TextIndent(firstLine = 30.sp)
                            )
                    )

                    composeCustomText(
                            text = "The line height of this text has been " +
                                    "increased hence you will be able to see more space between each " +
                                    "line in this paragraph.",
                            style = TextStyle(
                                    textAlign = TextAlign.Justify,
                                    lineHeight = 20.sp
                            )
                    )

                    val annotatedString = annotatedString {
                        append("This string has style spans")
                        addStyle(style = SpanStyle(color = Color.Red), start = 0,end = 4)
                        addStyle(style = SpanStyle(color = Color.Green), start = 5,end = 21)
                        addStyle(style = SpanStyle(color = Color.Blue), start = 22,end = 27)
                    }

                    Text(text = annotatedString,modifier = Modifier.padding(16.dp))
                    Divider(color = Color.Gray)

                    Surface(color = Color.Yellow) {
                        Text(
                                text = "This text has a background color",
                                modifier = Modifier.padding(16.dp)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun composeCustomText(text:String,style: TextStyle?=null,maxLines :Int?=null,modifier: Modifier?=null){

    Text(
            text = text,
            modifier = modifier ?: Modifier.padding(16.dp),
            style = style ?: TextStyle.Default,
            overflow = TextOverflow.Ellipsis,
            maxLines = maxLines ?: Int.MAX_VALUE

    )
    Divider(color = Color.Gray)

}