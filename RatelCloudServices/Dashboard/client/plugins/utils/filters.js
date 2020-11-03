import Vue from 'vue';
import { rmb, dollar, strtruncate, timeconvert, currencyconvert, filenametruncate, booleanconvert} from '../../filters/index';

Vue.filter('rmb', rmb)
Vue.filter('dollar', dollar)
Vue.filter('strtruncate', strtruncate)
Vue.filter('timeconvert',timeconvert)
Vue.filter('currencyconvert',currencyconvert)
Vue.filter('filenametruncate',filenametruncate)
Vue.filter('booleanconvert',booleanconvert)
