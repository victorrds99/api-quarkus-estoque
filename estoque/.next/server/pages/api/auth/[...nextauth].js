"use strict";
/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
(() => {
var exports = {};
exports.id = "pages/api/auth/[...nextauth]";
exports.ids = ["pages/api/auth/[...nextauth]"];
exports.modules = {

/***/ "next-auth":
/*!****************************!*\
  !*** external "next-auth" ***!
  \****************************/
/***/ ((module) => {

module.exports = require("next-auth");

/***/ }),

/***/ "next-auth/providers/credentials":
/*!**************************************************!*\
  !*** external "next-auth/providers/credentials" ***!
  \**************************************************/
/***/ ((module) => {

module.exports = require("next-auth/providers/credentials");

/***/ }),

/***/ "(api)/./src/pages/api/auth/[...nextauth].ts":
/*!*********************************************!*\
  !*** ./src/pages/api/auth/[...nextauth].ts ***!
  \*********************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (__WEBPACK_DEFAULT_EXPORT__)\n/* harmony export */ });\n/* harmony import */ var next_auth__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! next-auth */ \"next-auth\");\n/* harmony import */ var next_auth__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(next_auth__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var next_auth_providers_credentials__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! next-auth/providers/credentials */ \"next-auth/providers/credentials\");\n/* harmony import */ var next_auth_providers_credentials__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(next_auth_providers_credentials__WEBPACK_IMPORTED_MODULE_1__);\n/* eslint-disable no-param-reassign */ \n\n/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (next_auth__WEBPACK_IMPORTED_MODULE_0___default()({\n    providers: [\n        next_auth_providers_credentials__WEBPACK_IMPORTED_MODULE_1___default()({\n            name: \"my-project\",\n            credentials: {\n                email: {\n                    label: \"email\",\n                    type: \"email\",\n                    placeholder: \"jsmith@example.com\"\n                },\n                password: {\n                    label: \"Password\",\n                    type: \"password\"\n                },\n                tenantKey: {\n                    label: \"Tenant Key\",\n                    type: \"text\"\n                }\n            },\n            async authorize (credentials) {\n                const user = {\n                    email: credentials === null || credentials === void 0 ? void 0 : credentials.email,\n                    password: credentials === null || credentials === void 0 ? void 0 : credentials.password\n                };\n                if (user) {\n                    return user;\n                }\n                throw new Error(\"Erro ao fazer login\");\n            }\n        })\n    ],\n    callbacks: {\n        jwt: ({ token , user  })=>{\n            if (user) {\n                token.id = user.id;\n            }\n            return token;\n        },\n        session: ({ session , token  })=>{\n            if (token) {\n                session.id = token.id;\n            }\n            return session;\n        }\n    },\n    secret: \"test\",\n    jwt: {\n        secret: \"test\"\n    }\n}));\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiKGFwaSkvLi9zcmMvcGFnZXMvYXBpL2F1dGgvWy4uLm5leHRhdXRoXS50cy5qcyIsIm1hcHBpbmdzIjoiOzs7Ozs7OztBQUFBLHNDQUFzQyxDQUNMO0FBQ2lDO0FBRWxFLGlFQUFlQSxnREFBUSxDQUFDO0lBQ3RCRSxTQUFTLEVBQUU7UUFDVEQsc0VBQW1CLENBQUM7WUFDbEJFLElBQUksRUFBRSxZQUFZO1lBQ2xCQyxXQUFXLEVBQUU7Z0JBQ1hDLEtBQUssRUFBRTtvQkFDTEMsS0FBSyxFQUFFLE9BQU87b0JBQ2RDLElBQUksRUFBRSxPQUFPO29CQUNiQyxXQUFXLEVBQUUsb0JBQW9CO2lCQUNsQztnQkFDREMsUUFBUSxFQUFFO29CQUFFSCxLQUFLLEVBQUUsVUFBVTtvQkFBRUMsSUFBSSxFQUFFLFVBQVU7aUJBQUU7Z0JBQ2pERyxTQUFTLEVBQUU7b0JBQ1RKLEtBQUssRUFBRSxZQUFZO29CQUNuQkMsSUFBSSxFQUFFLE1BQU07aUJBQ2I7YUFDRjtZQUNELE1BQU1JLFNBQVMsRUFBQ1AsV0FBVyxFQUFFO2dCQUMzQixNQUFNUSxJQUFJLEdBQUc7b0JBQ1hQLEtBQUssRUFBRUQsV0FBVyxhQUFYQSxXQUFXLFdBQU8sR0FBbEJBLEtBQUFBLENBQWtCLEdBQWxCQSxXQUFXLENBQUVDLEtBQUs7b0JBQ3pCSSxRQUFRLEVBQUVMLFdBQVcsYUFBWEEsV0FBVyxXQUFVLEdBQXJCQSxLQUFBQSxDQUFxQixHQUFyQkEsV0FBVyxDQUFFSyxRQUFRO2lCQUNoQztnQkFFRCxJQUFJRyxJQUFJLEVBQUU7b0JBQ1IsT0FBT0EsSUFBSSxDQUFDO2lCQUNiO2dCQUVELE1BQU0sSUFBSUMsS0FBSyxDQUFDLHFCQUFxQixDQUFDLENBQUM7YUFDeEM7U0FDRixDQUFDO0tBRUg7SUFDREMsU0FBUyxFQUFFO1FBQ1RDLEdBQUcsRUFBRSxDQUFDLEVBQUVDLEtBQUssR0FBRUosSUFBSSxHQUFFLEdBQUs7WUFDeEIsSUFBSUEsSUFBSSxFQUFFO2dCQUNSSSxLQUFLLENBQUNDLEVBQUUsR0FBR0wsSUFBSSxDQUFDSyxFQUFFLENBQUM7YUFDcEI7WUFFRCxPQUFPRCxLQUFLLENBQUM7U0FDZDtRQUNERSxPQUFPLEVBQUUsQ0FBQyxFQUFFQSxPQUFPLEdBQUVGLEtBQUssR0FBRSxHQUFLO1lBQy9CLElBQUlBLEtBQUssRUFBRTtnQkFDVEUsT0FBTyxDQUFDRCxFQUFFLEdBQUdELEtBQUssQ0FBQ0MsRUFBRSxDQUFDO2FBQ3ZCO1lBRUQsT0FBT0MsT0FBTyxDQUFDO1NBQ2hCO0tBQ0Y7SUFDREMsTUFBTSxFQUFFLE1BQU07SUFDZEosR0FBRyxFQUFFO1FBQ0hJLE1BQU0sRUFBRSxNQUFNO0tBQ2Y7Q0FDRixDQUFDLEVBQUMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9lc3RvcXVlLWZyb250Ly4vc3JjL3BhZ2VzL2FwaS9hdXRoL1suLi5uZXh0YXV0aF0udHM/NTBhMSJdLCJzb3VyY2VzQ29udGVudCI6WyIvKiBlc2xpbnQtZGlzYWJsZSBuby1wYXJhbS1yZWFzc2lnbiAqL1xuaW1wb3J0IE5leHRBdXRoIGZyb20gJ25leHQtYXV0aCc7XG5pbXBvcnQgQ3JlZGVudGlhbHNQcm92aWRlciBmcm9tICduZXh0LWF1dGgvcHJvdmlkZXJzL2NyZWRlbnRpYWxzJztcblxuZXhwb3J0IGRlZmF1bHQgTmV4dEF1dGgoe1xuICBwcm92aWRlcnM6IFtcbiAgICBDcmVkZW50aWFsc1Byb3ZpZGVyKHtcbiAgICAgIG5hbWU6ICdteS1wcm9qZWN0JyxcbiAgICAgIGNyZWRlbnRpYWxzOiB7XG4gICAgICAgIGVtYWlsOiB7XG4gICAgICAgICAgbGFiZWw6ICdlbWFpbCcsXG4gICAgICAgICAgdHlwZTogJ2VtYWlsJyxcbiAgICAgICAgICBwbGFjZWhvbGRlcjogJ2pzbWl0aEBleGFtcGxlLmNvbScsXG4gICAgICAgIH0sXG4gICAgICAgIHBhc3N3b3JkOiB7IGxhYmVsOiAnUGFzc3dvcmQnLCB0eXBlOiAncGFzc3dvcmQnIH0sXG4gICAgICAgIHRlbmFudEtleToge1xuICAgICAgICAgIGxhYmVsOiAnVGVuYW50IEtleScsXG4gICAgICAgICAgdHlwZTogJ3RleHQnLFxuICAgICAgICB9LFxuICAgICAgfSxcbiAgICAgIGFzeW5jIGF1dGhvcml6ZShjcmVkZW50aWFscykge1xuICAgICAgICBjb25zdCB1c2VyID0ge1xuICAgICAgICAgIGVtYWlsOiBjcmVkZW50aWFscz8uZW1haWwsXG4gICAgICAgICAgcGFzc3dvcmQ6IGNyZWRlbnRpYWxzPy5wYXNzd29yZCxcbiAgICAgICAgfTtcblxuICAgICAgICBpZiAodXNlcikge1xuICAgICAgICAgIHJldHVybiB1c2VyO1xuICAgICAgICB9XG5cbiAgICAgICAgdGhyb3cgbmV3IEVycm9yKCdFcnJvIGFvIGZhemVyIGxvZ2luJyk7XG4gICAgICB9LFxuICAgIH0pLFxuICAgIC8vIC4uLmFkZCBtb3JlIHByb3ZpZGVycyBoZXJlXG4gIF0sXG4gIGNhbGxiYWNrczoge1xuICAgIGp3dDogKHsgdG9rZW4sIHVzZXIgfSkgPT4ge1xuICAgICAgaWYgKHVzZXIpIHtcbiAgICAgICAgdG9rZW4uaWQgPSB1c2VyLmlkO1xuICAgICAgfVxuXG4gICAgICByZXR1cm4gdG9rZW47XG4gICAgfSxcbiAgICBzZXNzaW9uOiAoeyBzZXNzaW9uLCB0b2tlbiB9KSA9PiB7XG4gICAgICBpZiAodG9rZW4pIHtcbiAgICAgICAgc2Vzc2lvbi5pZCA9IHRva2VuLmlkO1xuICAgICAgfVxuXG4gICAgICByZXR1cm4gc2Vzc2lvbjtcbiAgICB9LFxuICB9LFxuICBzZWNyZXQ6ICd0ZXN0JyxcbiAgand0OiB7XG4gICAgc2VjcmV0OiAndGVzdCcsXG4gIH0sXG59KTtcbiJdLCJuYW1lcyI6WyJOZXh0QXV0aCIsIkNyZWRlbnRpYWxzUHJvdmlkZXIiLCJwcm92aWRlcnMiLCJuYW1lIiwiY3JlZGVudGlhbHMiLCJlbWFpbCIsImxhYmVsIiwidHlwZSIsInBsYWNlaG9sZGVyIiwicGFzc3dvcmQiLCJ0ZW5hbnRLZXkiLCJhdXRob3JpemUiLCJ1c2VyIiwiRXJyb3IiLCJjYWxsYmFja3MiLCJqd3QiLCJ0b2tlbiIsImlkIiwic2Vzc2lvbiIsInNlY3JldCJdLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///(api)/./src/pages/api/auth/[...nextauth].ts\n");

/***/ })

};
;

// load runtime
var __webpack_require__ = require("../../../webpack-api-runtime.js");
__webpack_require__.C(exports);
var __webpack_exec__ = (moduleId) => (__webpack_require__(__webpack_require__.s = moduleId))
var __webpack_exports__ = (__webpack_exec__("(api)/./src/pages/api/auth/[...nextauth].ts"));
module.exports = __webpack_exports__;

})();