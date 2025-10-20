import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppLayoutComponent } from './app/core/components/app-layout/app-layout.component';

bootstrapApplication(AppLayoutComponent, appConfig).catch((err) => console.error(err));
