# QA Group Project
This parent folder contains micro-services which facilitate the running of an Apartment Management System.
## Contents
 - **AMS - Project Overview**
	 - **Initial Overview**
		 - Plan
		 - Options Considered
		 - Project Outline - AMS
			 - Overall Architecture
			 - Database - Structure and Relationships
			 - Back-end - API Architecture
			 - Front-end - Wire Frame

## Initial Overview
### Plan
1.  **Gather general information about the project.** Interview relevant personnel to
determine what key functionality would be required in any potential solution. If a
version of the system already exists, also investigate how the current system could
be improved, and what parts of the current system they wish to retain.

2.  **Bring together initial findings.** Produce basic project outline. Make initial
assessment on project architecture, and which tools/technology may be suitable.
Conduct second round of interviews to verify any assumptions, gather additional
information, and ask more specific questions about the project.

3. **Construct full project overview.** Use feedback from second round of interviews to
produce a comprehensive plan for the project. Include a consideration of business
logic, front-end wireframes, use cases, and architecture and present to client for
approval. Make final decision on tools/ technology to be used.
### Options Considered
---
- **Interview management system** (**`Chester`**):
	- Automate the process of delivering interviews and recording assessment.
	- Persistent storage of interview results accessible by trainers/ management.
	- Report functionality for different trainers/ assessment day groups.
	- User account functionality with different access levels.
- **CV management system** (**`Bob/Dev`**):
	- Allow trainees to create a user profile, upload CVs to be stored persistently.
	- Trainer accounts can view trainee profiles, provide feedback on CVs.
	- Implement admin user with user/data management functionality.
	- User account functionality with different access levels.
- **Accommodation** (**`Hannah`**):
	- Persistent data storage (Stretch goal – security -- Adhere to GDPR).
	- Form-based search functionality (filterable by Name/Apartment/intake etc.).
	- Ability to edit data on both an individual, and a group basis (i.e by intake).
	- Note functionality to allow for comments/ important information to be stored.
	- Lightweight user-interface and data reporting features. Make sure to retain
	“wide” calendar view for displaying data over long timescales.
	- Keeping track of cleaning (roughly 1 apt/day), maintenance, and occupation.
	- Stretch goal – document repository – secure – keep track of all letters/notes
about people apartments tracked with that person.
	- Take over from current system (Excel spreadsheet) and move data across.
	- User account functionality (Stretch goal – security – Email validation)
	- Stretch goal – security – Encrypt data (hash) for added security.

### Project Outline - Accommodation Management System
#### Overall Architecture
![architecture-diagram]][Documentation/ArchitectureDiagram.png]