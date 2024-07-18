package meow.laser.com.features.login.util

fun isPhoneValid(phone: String): Boolean {
    val regex = Regex("\\+48\\d{9}")
    return phone.matches(regex)
}
