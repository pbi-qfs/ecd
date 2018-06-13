# Audit results

## Binary File Verification

### Dr. Garbage Tools

_Primary Source: https://sourceforge.net/projects/drgarbagetools/files/eclipse/4.4/stable/plugins/_ -> com.drgarbage.asm_5.0.3.201408050542.jar contains both files

* `./org.sf.feeling.decompiler/lib/com.drgarbage.asm.util_5.0.3.jar`
  * SHA-256: 06096adf6144ee613a9cc6d55325f6b1f04b03c52ca1841e9b3d7ae9dcadd2f2
  * Equal to the file of the same name in https://downloads.sourceforge.net/project/drgarbagetools/eclipse/4.4/stable/plugins/com.drgarbage.asm_5.0.3.201408050542.jar
* `./org.sf.feeling.decompiler/lib/com.drgarbage.asm_5.0.3.jar`
  * SHA-256: d14546c965fea4a8fef3f7c267788d9748058957b84ae11a9fb22d5e386921d1
  * Equal to the file of the same name in https://downloads.sourceforge.net/project/drgarbagetools/eclipse/4.4/stable/plugins/com.drgarbage.asm_5.0.3.201408050542.jar


### Apache commons

_Primary Source: https://commons.apache.org/downloads/index.html_

* `./org.sf.feeling.decompiler/lib/commons-codec-1.5.jar`
  * SHA-256: c7956fe621708e45314ebdf6a35e35c57f2ff80ba9c85dfafb1e43620af6c797
  * Equal to http://central.maven.org/maven2/commons-codec/commons-codec/1.5/commons-codec-1.5.jar
* `./org.sf.feeling.decompiler.source.attach/lib/commons-compress-1.3.jar`
  * SHA-256: 56291a5427f6c0abc0b34fbf9bfafa0c21b60d503ece95c38741424d76e2aa04
  * Equal to http://central.maven.org/maven2/org/apache/commons/commons-compress/1.3/commons-compress-1.3.jar
* `./org.sf.feeling.decompiler.source.attach/lib/commons-io-2.2.jar`
  * SHA-256: 675f60bd11a82d481736591fe4054c66471fa5463d45616652fd71585792ba87
  * Equal to http://central.maven.org/maven2/commons-io/commons-io/2.2/commons-io-2.2.jar
* `./org.sf.feeling.decompiler.source.attach/lib/commons-lang-2.6.jar`
  * SHA-256: 50f11b09f877c294d56f24463f47d28f929cf5044f648661c0f0cfbae9a2f49c
  * Equal to http://central.maven.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar

### Fernflower
_Primary Source: https://github.com/JetBrains/intellij-community/tree/master/plugins/java-decompiler/engine_
_Build Source: https://github.com/MinecraftForge/FernFlower with builds at http://files.minecraftforge.net/maven/net/minecraftforge/fernflower/_
* `./org.sf.feeling.decompiler/lib/fernflower-352.jar`
  * SHA-256: 799e1e968613abdb74a61bebb08c49132cde5c6eb8d8e5c80a768bfb57a44785
  * Version from http://files.minecraftforge.net/maven/net/minecraftforge/fernflower/352/fernflower-352.jar

### Minimal JSON
_Primary Source: https://github.com/ralfstx/minimal-json_

    * `./org.sf.feeling.decompiler/lib/json.jar`
      * SHA-256: e1d280900c78f18ae2e00c14e7410a77ba19cf084154b386532846aa6dc81721
      * Version from http://central.maven.org/maven2/com/eclipsesource/minimal-json/minimal-json/0.9.4/minimal-json-0.9.4.jar

### JSOUP
_Primary Source: http://jsoup.org/_

* `./org.sf.feeling.decompiler/lib/jsoup.jar`
  * SHA-256: fec4c4a7bb210e2d382ddef6ef9d86e8431aa6d7d3113d88132435483e4aa65e
  * Version from http://central.maven.org/maven2/org/jsoup/jsoup/1.9.2/jsoup-1.9.2.jar

### CFR
_Primary Source: http://www.benf.org/other/cfr/_

* `./org.sf.feeling.decompiler.cfr/lib/cfr_0_130.jar`
  * SHA-256: b66a1e59891a2585885b171b4ec6fcc0e20f0d419e90a153e5c01540bb1cc67f
  * Equal to http://www.benf.org/other/cfr/cfr_0_130.jar

### Procyon
_Primary Source: https://bitbucket.org/mstrobel/procyon/_
* `./org.sf.feeling.decompiler.procyon/lib/procyon.jar`
  * SHA-256: 64d469659852e53eb78394553a6b2e104a2a65625117130c640d4f798525426a
  * `gradle fatJar` build of https://bitbucket.org/mstrobel/procyon/commits/12cbbdd9dc6fde6b5155de3e3aebde8ce3f85df4?at=develop

### Netbeans CVSClient
_Primary Source: https://versioncontrol.netbeans.org/javacvs/library/_
* `./org.sf.feeling.decompiler.source.attach/lib/cvsclient-20060125.jar`

### Maven SCM
_Primary Source: https://maven.apache.org/scm/_
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-api-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-accurev-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-bazaar-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-clearcase-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-cvs-commons-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-cvsexe-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-cvsjava-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-git-commons-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-gitexe-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-hg-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-integrity-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-jazz-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-local-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-perforce-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-starteam-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-svn-commons-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-svnexe-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-synergy-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-tfs-1.9.4.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/maven-scm-provider-vss-1.9.4.jar`

### Nexus

* `./org.sf.feeling.decompiler.source.attach/lib/nexus-indexer-lucene-model-2.9.2-01.jar`
* `./org.sf.feeling.decompiler.source.attach/lib/nexus-restlet1x-model-2.9.2-01.jar`

### Plexus Utils
Primary Source: _https://github.com/codehaus-plexus/plexus-utils_
* `./org.sf.feeling.decompiler.source.attach/lib/plexus-utils-3.0.15.jar`

### JAD
_Primary Source: http://www.javadecompilers.com/jad_

* `./org.sf.feeling.decompiler.jad/src/native/jad/linux/jad`
  * SHA-256: 805527efac5b4f1d3982f20a8533142326cc397df1b2cf6012c12df91d4794f5
* `./org.sf.feeling.decompiler.jad/src/native/jad/macos/jad`
  * SHA-256: f88436c49ed025f62f87754eba0b0190568d1efa5a38199f427f7ade4f5d037e
* `./org.sf.feeling.decompiler.jad/src/native/jad/win32/jad.exe`
  * SHA-256: c5f43828592c7a47261b6baf89f13455423f9c528ed1b01e7148ba2475ed6126

## JD-Core
_Primary Source: https://github.com/java-decompiler/jd-eclipse/releases_

* `./org.sf.feeling.decompiler.jd/lib/jd-common-0.7.1.jar`
  * SHA-256: dfc8c400110b589b5347d6337aeea8d197539e9bc866789c319be6584688c41a
* `./org.sf.feeling.decompiler.jd/lib/jd-common-ide-0.7.1.jar`
  * SHA-256: 53a794093510ebb3c1411f1bf1acfb37616baea16ca11b1aa5cf5a0ec457856f
* `./org.sf.feeling.decompiler.jd/lib/jd-core-0.7.1.jar`
  * SHA-256: 4977fd2d30a42d54b197d0f80a21c623210e973dd0a781ba1dcbe2e59cf3d62a
