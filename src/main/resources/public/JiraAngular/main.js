(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<ng-container *ngIf=\"loading\">\n  <div class=\"loader-main\">\n    <mat-spinner class=\"spinner\"></mat-spinner>\n  </div>\n</ng-container>\n<ng-container>\n  <ng-container *ngIf=\"!iAmScrumMaster()\">\n    <app-jira-developer></app-jira-developer>\n  </ng-container>\n  <ng-container *ngIf=\"iAmScrumMaster()\">\n    <app-jira-scrummaster></app-jira-scrummaster>\n  </ng-container>\n</ng-container>\n"

/***/ }),

/***/ "./src/app/app.component.scss":
/*!************************************!*\
  !*** ./src/app/app.component.scss ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".loader-main {\n  height: 100vh;\n  text-align: center;\n  width: 100%; }\n  .loader-main .spinner {\n    display: inline-block;\n    margin-top: calc(50vh - 50px); }\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_service_general_check_user_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @app/service/general/check-user.service */ "./src/app/service/general/check-user.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = /** @class */ (function () {
    function AppComponent(checkUserService) {
        this.checkUserService = checkUserService;
        this.title = 'JiraAngular';
        this.test = 'hola';
        this.loading = true;
    }
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        //this.rol = this.checkUserService.rolData;
        this.checkUserService.checkUser().subscribe(function (next) {
        }, function (error) {
            _this.loading = false;
        }, function () {
            _this.user = _this.checkUserService.rolData;
            _this.loading = false;
        });
    };
    AppComponent.prototype.iAmScrumMaster = function () {
        if (this.user.rol == "scrum master") {
            return true;
        }
        return false;
    };
    AppComponent.prototype.testFn = function () {
        var _this = this;
        this.checkUserService.checkUser().subscribe(function (next) {
        }, function (error) {
            _this.test = 'error';
        }, function () {
            _this.test = 'finalizo';
        });
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.scss */ "./src/app/app.component.scss")]
        }),
        __metadata("design:paramtypes", [_app_service_general_check_user_service__WEBPACK_IMPORTED_MODULE_1__["CheckUserService"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _service_http_interceptors_index__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./service/http-interceptors/index */ "./src/app/service/http-interceptors/index.ts");
/* harmony import */ var _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/progress-spinner */ "./node_modules/@angular/material/esm5/progress-spinner.es5.js");
/* harmony import */ var _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/slide-toggle */ "./node_modules/@angular/material/esm5/slide-toggle.es5.js");
/* harmony import */ var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/toolbar */ "./node_modules/@angular/material/esm5/toolbar.es5.js");
/* harmony import */ var _angular_material_card__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/card */ "./node_modules/@angular/material/esm5/card.es5.js");
/* harmony import */ var _angular_material_chips__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/material/chips */ "./node_modules/@angular/material/esm5/chips.es5.js");
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/material/grid-list */ "./node_modules/@angular/material/esm5/grid-list.es5.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/esm5/form-field.es5.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/esm5/input.es5.js");
/* harmony import */ var _angular_material_divider__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/material/divider */ "./node_modules/@angular/material/esm5/divider.es5.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/esm5/button.es5.js");
/* harmony import */ var _component_jira_scrummaster_jira_scrummaster_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./component/jira-scrummaster/jira-scrummaster.component */ "./src/app/component/jira-scrummaster/jira-scrummaster.component.ts");
/* harmony import */ var _component_jira_developer_jira_developer_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./component/jira-developer/jira-developer.component */ "./src/app/component/jira-developer/jira-developer.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"],
                _component_jira_scrummaster_jira_scrummaster_component__WEBPACK_IMPORTED_MODULE_17__["JiraScrummasterComponent"],
                _component_jira_developer_jira_developer_component__WEBPACK_IMPORTED_MODULE_18__["JiraDeveloperComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_1__["BrowserAnimationsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_7__["MatProgressSpinnerModule"],
                _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_8__["MatSlideToggleModule"],
                _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_9__["MatToolbarModule"],
                _angular_material_card__WEBPACK_IMPORTED_MODULE_10__["MatCardModule"],
                _angular_material_chips__WEBPACK_IMPORTED_MODULE_11__["MatChipsModule"],
                _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_12__["MatGridListModule"],
                _angular_material_form_field__WEBPACK_IMPORTED_MODULE_13__["MatFormFieldModule"],
                _angular_material_divider__WEBPACK_IMPORTED_MODULE_15__["MatDividerModule"],
                _angular_material_button__WEBPACK_IMPORTED_MODULE_16__["MatButtonModule"],
                _angular_material_input__WEBPACK_IMPORTED_MODULE_14__["MatInputModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"]
            ],
            providers: [_service_http_interceptors_index__WEBPACK_IMPORTED_MODULE_6__["httpInterceptorProviders"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/component/jira-developer/jira-developer.component.html":
/*!************************************************************************!*\
  !*** ./src/app/component/jira-developer/jira-developer.component.html ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-toolbar color=\"primary\">\n  <mat-toolbar-row>\n    <div class=\"container\">\n      <mat-toolbar-row>\n        <span>Menu Developer</span>\n        <span class=\"fill-space\"></span>\n        <span>Jira Scrum Agent</span>\n      </mat-toolbar-row>\n    </div>\n  </mat-toolbar-row>\n</mat-toolbar>\n<div class=\"sub-header\">\n  <div class=\"container\">\n    <h5>Issues Pendientes</h5>\n  </div>\n</div>\n\n<div class=\"container\">\n  <div class=\"row\">\n\n    <ng-container *ngFor=\"let devDato of devDatos | async\">\n      <div class=\"col-sm-12 container-card\">\n        <mat-card>\n          <mat-card-content>\n            <div class=\"row\">\n              <div class=\"col-sm-3\">\n                <mat-toolbar color=\"primary\">\n                  <mat-toolbar-row>\n                    <span>{{ devDato.nombreIssue }}</span>\n                  </mat-toolbar-row>\n                </mat-toolbar>\n              </div>\n\n              <div class=\"col-sm-6\">\n                <div class=\"col-sm-12\">\n                  <h6>Etiquetas:</h6>\n                  <mat-chip-list>\n                    <ng-container *ngFor=\"let tag of devDato.tags\">\n                      <mat-chip color=\"primary\" selected [disableRipple]=\"true\">\n                        {{ tag.nombre }}\n                      </mat-chip>\n                    </ng-container>\n                  </mat-chip-list>\n                </div>\n                <mat-divider></mat-divider>\n                <div class=\"col-sm-12\">\n                  <h6>Prioridad:</h6>\n                  <mat-chip color=\"warn\" selected [disableRipple]=\"true\">\n                    {{ devDato.prioridad }}\n                  </mat-chip>\n                </div>\n              </div>\n\n              <div class=\"col-sm-3\">\n                <div class=\"col-sm-12\">\n                  <h6>Auto-Evaluación</h6>\n                  <p>Contanos como te sentiste con esta Tarea con un valor de 1 a 10, siendo 1 la peor calificación y 10 la mejor calificación</p>\n                </div>\n                <div class=\"col-sm-12 text-center\">\n                  <mat-form-field class=\"puntaje\" appearance=\"outline\">\n                    <mat-label>Puntaje</mat-label>\n                    <input matInput type=\"number\" [ngModel]=\"ngModelHash.get(devDato.id)\" (ngModelChange)=\"updateHasMap(devDato.id, $event)\">\n                  </mat-form-field>\n                </div>\n                <div class=\"col-sm-12\">\n                  <button class=\"float-right\" mat-flat-button color=\"primary\" [disabled]=\"ngModelHash.get(devDato.id) === null\" (click)=\"sendEvaluation(devDato.id)\">Enviar</button>\n                </div>\n              </div>\n            </div>\n          </mat-card-content>\n        </mat-card>\n      </div>\n    </ng-container>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/component/jira-developer/jira-developer.component.scss":
/*!************************************************************************!*\
  !*** ./src/app/component/jira-developer/jira-developer.component.scss ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sub-header {\n  background-color: #EEE;\n  width: 100%; }\n  .sub-header .container {\n    padding: 5px 32px 1px; }\n  .fill-space {\n  -webkit-box-flex: 1;\n          flex: 1 1 auto; }\n  .container-card {\n  padding-top: 10px;\n  padding-bottom: 10px; }\n  .col-sm-12 {\n  padding-top: 10px;\n  padding-bottom: 15px; }\n  .puntaje {\n  width: 100px; }\n  .puntaje input {\n    font-size: 32px;\n    text-align: center; }\n"

/***/ }),

/***/ "./src/app/component/jira-developer/jira-developer.component.ts":
/*!**********************************************************************!*\
  !*** ./src/app/component/jira-developer/jira-developer.component.ts ***!
  \**********************************************************************/
/*! exports provided: JiraDeveloperComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JiraDeveloperComponent", function() { return JiraDeveloperComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_service_data_dev_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @app/service/data/dev.service */ "./src/app/service/data/dev.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var JiraDeveloperComponent = /** @class */ (function () {
    function JiraDeveloperComponent(devService) {
        this.devService = devService;
    }
    JiraDeveloperComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.ngModelHash = new Map();
        this.devDatos = this.devService.devDatos;
        this.devDatos.subscribe(function (datos) { return datos.forEach(function (dato) { return _this.ngModelHash.set(dato.id, null); }); });
        this.devService.loadDataDev();
        this.ngModelHash.set(123, null);
    };
    JiraDeveloperComponent.prototype.getNota = function (issue) {
        return "Se estimo un tiempo de " +
            issue.diasEstimados +
            ", y se tardo " +
            //this.getDiferenceInDays(issue.fechaIni, issue.fechaFin) +
            " dias en completar esta Tarea.";
    };
    JiraDeveloperComponent.prototype.getDiferenceInDays = function (dateIni, dateFin) {
        return Math.abs(dateFin.getTime() - dateIni.getTime()) / (1000 * 60 * 60 * 24);
    };
    JiraDeveloperComponent.prototype.updateHasMap = function (id, value) {
        console.log(id, value);
        if (value < 1) {
            this.ngModelHash.set(id, 1);
        }
        else if (value > 10) {
            this.ngModelHash.set(id, 10);
        }
        else {
            this.ngModelHash.set(id, value);
        }
    };
    JiraDeveloperComponent.prototype.sendEvaluation = function (id) {
        console.log(id, this.ngModelHash.get(id));
        var issue = {
            id: id,
            dificultad: this.ngModelHash.get(id)
        };
        //this.devService.updateDataDev(issue);
        this.devService.updateDataDevById(id, this.ngModelHash.get(id));
        console.log(issue);
    };
    JiraDeveloperComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-jira-developer',
            template: __webpack_require__(/*! ./jira-developer.component.html */ "./src/app/component/jira-developer/jira-developer.component.html"),
            styles: [__webpack_require__(/*! ./jira-developer.component.scss */ "./src/app/component/jira-developer/jira-developer.component.scss")]
        }),
        __metadata("design:paramtypes", [_app_service_data_dev_service__WEBPACK_IMPORTED_MODULE_1__["DevService"]])
    ], JiraDeveloperComponent);
    return JiraDeveloperComponent;
}());



/***/ }),

/***/ "./src/app/component/jira-scrummaster/jira-scrummaster.component.html":
/*!****************************************************************************!*\
  !*** ./src/app/component/jira-scrummaster/jira-scrummaster.component.html ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-toolbar color=\"primary\">\n  <mat-toolbar-row>\n    <div class=\"container\">\n      <mat-toolbar-row>\n        <span>Menu Scrum Master</span>\n        <span class=\"fill-space\"></span>\n        <span>Jira Scrum Agent</span>\n      </mat-toolbar-row>\n    </div>\n  </mat-toolbar-row>\n</mat-toolbar>\n<div class=\"sub-header\">\n  <div class=\"container\">\n    <h5>Issues Pendientes</h5>\n  </div>\n</div>\n\n<div class=\"container\">\n  <div class=\"row\">\n\n    <ng-container *ngFor=\"let smDato of smDatos | async\">\n      <div class=\"col-sm-6 container-card\">\n        <mat-card>\n\n          <mat-chip class=\"float-right\" color=\"warn\" selected [disableRipple]=\"true\">\n            {{ smDato.issueResponse.prioridad }}\n          </mat-chip>\n\n          <mat-card-header>\n            <mat-card-title>\n              {{ smDato.issueResponse.nombreIssue }}\n            </mat-card-title>\n            <mat-card-subtitle>\n              <mat-chip-list>\n                <ng-container *ngFor=\"let tag of smDato.issueResponse.tags\">\n                  <mat-chip color=\"primary\" selected [disableRipple]=\"true\">\n                    {{ tag.nombre }}\n                  </mat-chip>\n                </ng-container>\n              </mat-chip-list>\n            </mat-card-subtitle>\n          </mat-card-header>\n\n          <mat-card-content>\n            <h6>Developer Recomendado: </h6>\n            <mat-toolbar color=\"primary\">\n              <mat-toolbar-row>\n                <span>{{ getNameLastname(smDato.usuarioResponse) }}</span>\n                <span class=\"fill-space\"></span>\n                <mat-chip color=\"accent\" selected [disableRipple]=\"true\">\n                  {{ smDato.usuarioResponse.rol }}\n                </mat-chip>\n              </mat-toolbar-row>\n            </mat-toolbar>\n          </mat-card-content>\n\n        </mat-card>\n      </div>\n    </ng-container>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/component/jira-scrummaster/jira-scrummaster.component.scss":
/*!****************************************************************************!*\
  !*** ./src/app/component/jira-scrummaster/jira-scrummaster.component.scss ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sub-header {\n  background-color: #EEE;\n  width: 100%; }\n  .sub-header .container {\n    padding: 5px 32px 1px; }\n  .fill-space {\n  -webkit-box-flex: 1;\n          flex: 1 1 auto; }\n  .container-card {\n  padding-top: 10px;\n  padding-bottom: 10px; }\n"

/***/ }),

/***/ "./src/app/component/jira-scrummaster/jira-scrummaster.component.ts":
/*!**************************************************************************!*\
  !*** ./src/app/component/jira-scrummaster/jira-scrummaster.component.ts ***!
  \**************************************************************************/
/*! exports provided: JiraScrummasterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JiraScrummasterComponent", function() { return JiraScrummasterComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_service_data_sm_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @app/service/data/sm.service */ "./src/app/service/data/sm.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var JiraScrummasterComponent = /** @class */ (function () {
    function JiraScrummasterComponent(smService) {
        this.smService = smService;
    }
    JiraScrummasterComponent.prototype.ngOnInit = function () {
        this.smDatos = this.smService.smDatos;
        this.smService.loadDataSm();
    };
    JiraScrummasterComponent.prototype.getNameLastname = function (user) {
        return user.name;
    };
    JiraScrummasterComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-jira-scrummaster',
            template: __webpack_require__(/*! ./jira-scrummaster.component.html */ "./src/app/component/jira-scrummaster/jira-scrummaster.component.html"),
            styles: [__webpack_require__(/*! ./jira-scrummaster.component.scss */ "./src/app/component/jira-scrummaster/jira-scrummaster.component.scss")]
        }),
        __metadata("design:paramtypes", [_app_service_data_sm_service__WEBPACK_IMPORTED_MODULE_1__["SmService"]])
    ], JiraScrummasterComponent);
    return JiraScrummasterComponent;
}());



/***/ }),

/***/ "./src/app/service/data/dev.service.ts":
/*!*********************************************!*\
  !*** ./src/app/service/data/dev.service.ts ***!
  \*********************************************/
/*! exports provided: DevService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DevService", function() { return DevService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
        'Content-Type': 'application/json'
    })
};
var devUrl = "agent/show-issues";
var devPutUrl = "agent/evaluate"; // mandar issue
var DevService = /** @class */ (function () {
    function DevService(http) {
        this.http = http;
        this.dataStore = { devDatos: [] };
        this._devDatos = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"]([]);
        this.devDatos = this._devDatos.asObservable();
    }
    DevService.prototype.loadDataDev = function () {
        var _this = this;
        var obs = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
        this.getDataDev().subscribe(function (devDatos) {
            _this.dataStore.devDatos = devDatos;
            _this._devDatos.next(Object.assign({}, _this.dataStore).devDatos);
        }, function (error) {
            obs.error(error);
        }, function () {
            obs.complete();
        });
        return obs.asObservable();
    };
    DevService.prototype.updateDataDev = function (issue) {
        var _this = this;
        var obs = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
        this.putDataDev(issue).subscribe(function (issue) {
            _this.dataStore.devDatos.forEach(function (item, index) {
                if (item.id === issue.id) {
                    _this.dataStore.devDatos.splice(index, 1);
                }
            });
            _this._devDatos.next(Object.assign({}, _this.dataStore).devDatos);
        }, function (error) {
            obs.error(error);
        }, function () {
            obs.complete();
        });
        return obs.asObservable();
    };
    DevService.prototype.updateDataDevById = function (id, evaluation) {
        var _this = this;
        var obs = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
        this.putDataDevByID(id, evaluation).subscribe(function (issue) {
            _this.dataStore.devDatos.forEach(function (item, index) {
                if (item.id === issue.id) {
                    _this.dataStore.devDatos.splice(index, 1);
                }
            });
            _this._devDatos.next(Object.assign({}, _this.dataStore).devDatos);
        }, function (error) {
            obs.error(error);
        }, function () {
            obs.complete();
        });
        return obs.asObservable();
    };
    DevService.prototype.getDataDev = function () {
        return this.http.get(devUrl).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (err) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])("Error thrown from catchError: ", err);
        }));
    };
    DevService.prototype.putDataDev = function (issue) {
        return this.http.put(devPutUrl, issue, httpOptions).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (err) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])("Error thrown from catchError: ", err);
        }));
    };
    DevService.prototype.putDataDevByID = function (id, evaluation) {
        var url = devPutUrl + "/" + id + "/" + evaluation;
        return this.http.get(url).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (err) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])("Error thrown from catchError: ", err);
        }));
    };
    DevService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], DevService);
    return DevService;
}());



/***/ }),

/***/ "./src/app/service/data/sm.service.ts":
/*!********************************************!*\
  !*** ./src/app/service/data/sm.service.ts ***!
  \********************************************/
/*! exports provided: SmService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SmService", function() { return SmService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var smUrl = "agent/assign-issues";
var SmService = /** @class */ (function () {
    function SmService(http) {
        this.http = http;
        this.dataStore = { smDatos: [] };
        this._smDatos = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"]([]);
        this.smDatos = this._smDatos.asObservable();
    }
    SmService.prototype.loadDataSm = function () {
        var _this = this;
        var obs = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
        this.getDataSm().subscribe(function (smDatos) {
            console.log('en curso: ');
            console.log(smDatos);
            _this.dataStore.smDatos = smDatos;
            _this._smDatos.next(Object.assign({}, _this.dataStore).smDatos);
        }, function (error) {
            console.log('error: ');
            console.log(_this.dataStore.smDatos);
            obs.error(error);
        }, function () {
            console.log('finalizo: ');
            console.log(_this.dataStore.smDatos);
            obs.complete();
        });
        return obs.asObservable();
    };
    SmService.prototype.getDataSm = function () {
        return this.http.get(smUrl).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (err) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])("Error thrown from catchError");
        }));
    };
    SmService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], SmService);
    return SmService;
}());



/***/ }),

/***/ "./src/app/service/general/check-user.service.ts":
/*!*******************************************************!*\
  !*** ./src/app/service/general/check-user.service.ts ***!
  \*******************************************************/
/*! exports provided: CheckUserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CheckUserService", function() { return CheckUserService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var checkUrl = "agent/check-user-rol";
var CheckUserService = /** @class */ (function () {
    function CheckUserService(http) {
        this.http = http;
    }
    CheckUserService.prototype.checkUser = function () {
        var _this = this;
        var obs = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
        this.getCheckUser().subscribe(function (rol) {
            _this.rolData = rol;
            console.log('en curso: ');
            console.log(rol);
        }, function (error) {
            obs.error(error);
        }, function () {
            obs.complete();
        });
        return obs.asObservable();
    };
    CheckUserService.prototype.getCheckUser = function () {
        return this.http.get(checkUrl).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (err) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])("Error thrown from catchError");
        }));
    };
    CheckUserService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], CheckUserService);
    return CheckUserService;
}());



/***/ }),

/***/ "./src/app/service/http-interceptors/index.ts":
/*!****************************************************!*\
  !*** ./src/app/service/http-interceptors/index.ts ***!
  \****************************************************/
/*! exports provided: httpInterceptorProviders */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "httpInterceptorProviders", function() { return httpInterceptorProviders; });
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _server_interceptor__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./server-interceptor */ "./src/app/service/http-interceptors/server-interceptor.ts");


/** Http interceptor providers in outside-in order */
var httpInterceptorProviders = [
    { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HTTP_INTERCEPTORS"], useClass: _server_interceptor__WEBPACK_IMPORTED_MODULE_1__["ServerInterceptor"], multi: true },
];


/***/ }),

/***/ "./src/app/service/http-interceptors/server-interceptor.ts":
/*!*****************************************************************!*\
  !*** ./src/app/service/http-interceptors/server-interceptor.ts ***!
  \*****************************************************************/
/*! exports provided: ServerInterceptor */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ServerInterceptor", function() { return ServerInterceptor; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var ServerInterceptor = /** @class */ (function () {
    function ServerInterceptor() {
    }
    ServerInterceptor.prototype.intercept = function (req, next) {
        var serverReq = req.clone({
            url: "https://876713af.ngrok.io/" + req.url
        });
        return next.handle(serverReq);
    };
    ServerInterceptor = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])()
    ], ServerInterceptor);
    return ServerInterceptor;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/jis/Projects/JiraAngular/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map