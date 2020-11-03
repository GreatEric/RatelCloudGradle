const currencyconvert = (i, locale, currency) => {
  if (locale == null) {
    locale = 'en-AU';
  }
  if (currency == null) {
    currency = 'AUD';
  }
  return new Intl.NumberFormat(locale, { style: 'currency', currency: currency }).format(i)
}

export default currencyconvert

// reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Intl/NumberFormat
