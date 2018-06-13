# Enhanced Class Decompiler
Enhanced Class Decompiler integrates **JD**, **Jad**, **FernFlower**, **CFR**, **Procyon** seamlessly with Eclipse and allows Java developers to **debug class files without source code directly**. It also integrates with the eclipse class editor, m2e plugin, supports **Javadoc**,  **reference search**, **library source attaching**, **byte code view** and the syntax of JDK8 **lambda** expression.

<p align="center"><img src="https://ecd-plugin.github.io/ecd/doc/o_debug_class.png"></p>

## Description
Enhanced Class Decompiler is a plug-in for the Eclipse platform. It integrates JD, Jad, FernFlower, CFR, Procyon seamlessly with Eclipse, allows you to display all the Java sources during your debugging process, even if you do not have them all, and you can debug these class files without source code directly.

## Why is this plug-in "enhanced"?
This is an ad-free fork of the Eclipse Decompiler Plugin. So we enhanced it by removing all code which might compromise your privacy or security (to the best of our knowledge).

## How to install Enhanced Class Decompiler?

Drag and Drop installation: [![Drag to your running Eclipse workspace.](https://marketplace.eclipse.org/sites/all/themes/solstice/public/images/marketplace/btn-install.png)](http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=3644319 "Drag to your running Eclipse workspace.")

_If you have currently the "Eclipse" Class Decompiler installed, it is recommended to [uninstall that plug-in](http://www.cpupk.com/decompiler/#how-to-uninstall-eclipse-class-decompiler-) first and remove the corresponding update site from your Eclipse installation._
  1. Launch _Eclipse_,
  2. Click on _"Help > Install New Software..."_,
  3. Click on button _"Add..."_ to add an new repository,
  4. Enter name as _"Enhanced Class Decompiler Update Site"_ and enter location as _"[https://ecd-plugin.github.io/update](https://ecd-plugin.github.io/update)"_, then click on button _"OK"_,
  5. Check _"Enhanced Class Decompiler"_,
  6. Next, next, next... and restart.

## How to check the file associations?
  1. Click on _"Window > Preferences > General > Editors > File Associations"_
  2. _"*.class"_ : _"Class Decompiler Viewer"_ is selected by default.
  3. _"*.class without source"_ : _"Class Decompiler Viewer"_ is selected by default.

## How to configure Enhanced Class Decompiler?
  1. Click on _"Window > Preferences > Java > Decompiler"_

## How to uninstall Enhanced Class Decompiler?
  1. Click on _"Help > About Eclipse > Installation Details > Installation Software"_,
  2. Select _"Enhanced Class Decompiler"_,
  3. Click on _"Uninstall..."_.

## How to build from source?

  If you want to test the latest features of this plugin, you have to build it from source. For this, proceed as following:

  1. Clone this project
  1. Clone https://github.com/ecd-plugin/update next to this project
  1. Run mvn clean package

  If you want to use Eclipse and help developing, continue like this:

  4. Install _Eclipse for RCP and RAP Developers_
  3. Import all projects into Eclipse by selecting _File_ > _Import_ > _General_ > _Existing Projects into Workspace_ > _Next_ and enter the parent of the cloned directory as "root directory".
  4. Open the _org.sf.feeling.decompiler.updatesite_ project in the Package Explorer
  5. Open the file _site.xml_ within the project
  6. Press "Build All"
  7. Copy the jar files generated in the _build/features_ and _build/plugins_ folder of the project into the correspondent folders of your normal Eclipse installation.

## License

The main plugin and most of the optional feature plugins are licensed under the [Eclipse Public License v1.0](http://www.eclipse.org/legal/epl-v10.html)

### org.sf.feeling.decompiler.jd

The optional and independent _org.sf.feeling.decompiler.jd_ project and its used libraries are licensed under the [GPL 3](https://www.gnu.org/licenses/gpl-3.0-standalone.html)

## Contributors

* Chen Chao (cnfree2000@hotmail.com) - initial API and implementation
* Robert Zenz
* Pascal Bihler
* Nick Lombard

## Changelog

* Version 3.1.0
  * Updated Embedded Decompilers
    * CFR to version 0_130

* Version 3.0.0
  * Removed adware code fragments
  * Removed self-update feature (Eclipse handles updates fine)
  * Removed extra-header in code (Issue [upstream#2](https://github.com/cnfree/Eclipse-Class-Decompiler/issues/28))
  * Display information about class being decompiled in editor title (Issue #3)
  * Made plug-in work with Java9 BETA JDT core
