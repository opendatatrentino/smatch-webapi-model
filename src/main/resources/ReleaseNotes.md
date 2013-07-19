# Relase Notes: Name of the Module. version @{project.version.current} 

Date of the release: @{project.release.date}

Design Lead: person responsible for the Conceptual/Architectural? Design of the module

Developer Lead: person responsible for the code of the module

# Description 
## Goal of the module 
Paragraph with the overall goal of the module, optionally a use-case diagram of the main function (by the Design Lead). This is required for mayor releases, and minor ones including only bug fixing should point to the wiki page or release notes that explains this.

If applicable, paragraph about how this module interacts with others, optionally an architectural figure (by the Design Lead). For minor releases this is not compulsory, but a pointer to the mayor release where this is explained is needed.

# Documentation
A link to the conceptual documents (tech reports, papers, if any) that details the theory behind this (by the Design Lead)

URL of the Javadocs of the module. Note that the Javadocs have to be decompressed and made publicly available at https://sweb.science.unitn.it/javadocs/MVN_ARTIFACT_ID/MVN_PROJECT_VERSION.
All the versions must be available, i.e., the javadocs of old versions should not be overwritten, but versioned using their URLs.

https://sweb.science.unitn.it/javadocs/@{project.name}/@{project.version.current}


# Requirements  
System requirements, with the specification with which platforms the modules have been tested (win32/64, java32/64, postgres8.3/9.0/…). Note changes, like “Discontinued support for Windows XP.”

# Installation and configuration 
How to install the module (by Developer Lead). Or a link to the page that has the up to date (tested) installation instructions of the current version of the release of the system (not an old one that does not match fully and thoroughly)

How to configure the module (by Developer Lead). Or a link to the page that contains the configuration procedure that is applicable to this release. Note that if there has been a modification to some parts of the module being released, the configuration documentation has to reflect this changes, i.e., it cannot be out of date.

Data migration to this release from the previous release and back-up instructions in case there is a change in the underlying data model that is used by the module.

# Known issues 
List of known issues, and/or unsolved reported bugs, with their links to the trac system.

@{tickets.type=bug&status=!closed&milestone=current}

# Past releases 
Pointer to the past release notes pages.

https://sweb.science.unitn.it/trac/sweb/wiki/ReleaseNotes/@{project.name}

# License 
All the content of this project is copyrighted by the Knowdive group and should be deemed as confidential and not circulated without the written permission of Prof. Fausto Giunchiglia