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
exports.id = "pages/api/login";
exports.ids = ["pages/api/login"];
exports.modules = {

/***/ "axios":
/*!************************!*\
  !*** external "axios" ***!
  \************************/
/***/ ((module) => {

module.exports = require("axios");

/***/ }),

/***/ "(api)/./src/pages/api/login.ts":
/*!********************************!*\
  !*** ./src/pages/api/login.ts ***!
  \********************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (__WEBPACK_DEFAULT_EXPORT__)\n/* harmony export */ });\n/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! axios */ \"axios\");\n/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(axios__WEBPACK_IMPORTED_MODULE_0__);\n\nconst login = async (req, res)=>{\n    if (req.method === \"GET\") {\n        try {\n            const { data  } = await axios__WEBPACK_IMPORTED_MODULE_0___default().get(\"http://localhost:8080/login\", {\n                headers: {\n                    accept: \"application/json\"\n                }\n            });\n            return res.status(200).json(data);\n        } catch (error) {\n            return res.status(500).send(\"Internal server error\");\n        }\n    }\n    res.setHeader(\"Allow\", \"GET\");\n    return res.status(405).end(\"Method not allowed\");\n};\n/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (login);\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiKGFwaSkvLi9zcmMvcGFnZXMvYXBpL2xvZ2luLnRzLmpzIiwibWFwcGluZ3MiOiI7Ozs7OztBQUEwQjtBQUkxQixNQUFNQyxLQUFLLEdBQUcsT0FBT0MsR0FBbUIsRUFBRUMsR0FBb0IsR0FBSztJQUNqRSxJQUFJRCxHQUFHLENBQUNFLE1BQU0sS0FBSyxLQUFLLEVBQUU7UUFDeEIsSUFBSTtZQUNGLE1BQU0sRUFBRUMsSUFBSSxHQUFFLEdBQUcsTUFBTUwsZ0RBQVMsQ0FBbUIsNkJBQTZCLEVBQUU7Z0JBQ2hGTyxPQUFPLEVBQUU7b0JBQ1BDLE1BQU0sRUFBRSxrQkFBa0I7aUJBQzNCO2FBQ0YsQ0FBQztZQUVGLE9BQU9MLEdBQUcsQ0FBQ00sTUFBTSxDQUFDLEdBQUcsQ0FBQyxDQUFDQyxJQUFJLENBQUNMLElBQUksQ0FBQyxDQUFDO1NBQ25DLENBQUMsT0FBT00sS0FBSyxFQUFFO1lBQ2QsT0FBT1IsR0FBRyxDQUFDTSxNQUFNLENBQUMsR0FBRyxDQUFDLENBQUNHLElBQUksQ0FBQyx1QkFBdUIsQ0FBQyxDQUFDO1NBQ3REO0tBQ0Y7SUFFRFQsR0FBRyxDQUFDVSxTQUFTLENBQUMsT0FBTyxFQUFFLEtBQUssQ0FBQyxDQUFDO0lBQzlCLE9BQU9WLEdBQUcsQ0FBQ00sTUFBTSxDQUFDLEdBQUcsQ0FBQyxDQUFDSyxHQUFHLENBQUMsb0JBQW9CLENBQUMsQ0FBQztDQUNsRDtBQUVELGlFQUFlYixLQUFLLEVBQUMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9lc3RvcXVlLWZyb250Ly4vc3JjL3BhZ2VzL2FwaS9sb2dpbi50cz9kYTliIl0sInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBheGlvcyBmcm9tICdheGlvcyc7XG5pbXBvcnQgeyBOZXh0QXBpUmVxdWVzdCwgTmV4dEFwaVJlc3BvbnNlIH0gZnJvbSAnbmV4dCc7XG5pbXBvcnQgeyBQcm92aWRlcnNQcm9wcyB9IGZyb20gJy4uLy4uL2NvbnRleHQvdXNlUXVhcmt1cyc7XG5cbmNvbnN0IGxvZ2luID0gYXN5bmMgKHJlcTogTmV4dEFwaVJlcXVlc3QsIHJlczogTmV4dEFwaVJlc3BvbnNlKSA9PiB7XG4gIGlmIChyZXEubWV0aG9kID09PSAnR0VUJykge1xuICAgIHRyeSB7XG4gICAgICBjb25zdCB7IGRhdGEgfSA9IGF3YWl0IGF4aW9zLmdldDxQcm92aWRlcnNQcm9wc1tdPignaHR0cDovL2xvY2FsaG9zdDo4MDgwL2xvZ2luJywge1xuICAgICAgICBoZWFkZXJzOiB7XG4gICAgICAgICAgYWNjZXB0OiAnYXBwbGljYXRpb24vanNvbicsXG4gICAgICAgIH0sXG4gICAgICB9KTtcblxuICAgICAgcmV0dXJuIHJlcy5zdGF0dXMoMjAwKS5qc29uKGRhdGEpO1xuICAgIH0gY2F0Y2ggKGVycm9yKSB7XG4gICAgICByZXR1cm4gcmVzLnN0YXR1cyg1MDApLnNlbmQoJ0ludGVybmFsIHNlcnZlciBlcnJvcicpO1xuICAgIH1cbiAgfVxuXG4gIHJlcy5zZXRIZWFkZXIoJ0FsbG93JywgJ0dFVCcpO1xuICByZXR1cm4gcmVzLnN0YXR1cyg0MDUpLmVuZCgnTWV0aG9kIG5vdCBhbGxvd2VkJyk7XG59O1xuXG5leHBvcnQgZGVmYXVsdCBsb2dpbjtcbiJdLCJuYW1lcyI6WyJheGlvcyIsImxvZ2luIiwicmVxIiwicmVzIiwibWV0aG9kIiwiZGF0YSIsImdldCIsImhlYWRlcnMiLCJhY2NlcHQiLCJzdGF0dXMiLCJqc29uIiwiZXJyb3IiLCJzZW5kIiwic2V0SGVhZGVyIiwiZW5kIl0sInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///(api)/./src/pages/api/login.ts\n");

/***/ })

};
;

// load runtime
var __webpack_require__ = require("../../webpack-api-runtime.js");
__webpack_require__.C(exports);
var __webpack_exec__ = (moduleId) => (__webpack_require__(__webpack_require__.s = moduleId))
var __webpack_exports__ = (__webpack_exec__("(api)/./src/pages/api/login.ts"));
module.exports = __webpack_exports__;

})();