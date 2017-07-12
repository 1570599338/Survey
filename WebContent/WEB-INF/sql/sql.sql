
/****** Object:  Table [dbo].[project]    Script Date: 07/13/2017 00:31:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[project](
	[pk_id] [bigint] NOT NULL,
	[ID] [bigint] NOT NULL,
	[Number] [varchar](32) NOT NULL,
	[Name] [varchar](32) NOT NULL,
	[Type] [int] NOT NULL,
	[BeginDate] [datetime] NOT NULL,
	[EndDate] [datetime] NOT NULL,
	[Director] [varchar](64) NOT NULL,
	[Mebers] [varchar](256) NOT NULL,
	[QuotaServiceState] [int] NULL,
	[Remark] [varchar](512) NULL,
	[State] [int] NOT NULL,
	[Active] [int] NOT NULL,
	[CreatedAt] [datetime] NOT NULL,
	[CreatedBy] [varchar](32) NOT NULL,
	[UpdatedAt] [datetime] NULL,
	[UpdatedBy] [varchar](32) NULL,
PRIMARY KEY CLUSTERED 
(
	[pk_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[project] ADD  DEFAULT ('1') FOR [QuotaServiceState]
GO

ALTER TABLE [dbo].[project] ADD  DEFAULT (NULL) FOR [Remark]
GO

ALTER TABLE [dbo].[project] ADD  DEFAULT ('1') FOR [State]
GO

ALTER TABLE [dbo].[project] ADD  DEFAULT (NULL) FOR [UpdatedAt]
GO

ALTER TABLE [dbo].[project] ADD  DEFAULT (NULL) FOR [UpdatedBy]
GO









/****** Object:  Table [dbo].[template]    Script Date: 07/13/2017 00:32:25 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[template](
	[pk_id] [bigint] NOT NULL,
	[ID] [bigint] NOT NULL,
	[ProjectID] [bigint] NOT NULL,
	[Name] [varchar](1024) NULL,
	[Alias] [varchar](40) NOT NULL,
	[Remark] [varchar](256) NULL,
	[State] [int] NOT NULL,
	[Guide] [varchar](512) NULL,
	[SignAgreement] [int] NULL,
	[Rank] [int] NULL,
	[GoBack] [int] NULL,
	[ParticipantMask] [int] NULL,
	[WaitBeforeNext] [int] NOT NULL,
	[Active] [int] NULL,
	[CreatedAt] [datetime] NOT NULL,
	[CreatedBy] [varchar](32) NOT NULL,
	[UpdatedAt] [datetime] NULL,
	[UpdatedBy] [varchar](32) NULL,
PRIMARY KEY CLUSTERED 
(
	[pk_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[template]  WITH CHECK ADD  CONSTRAINT [template_project_projectid] FOREIGN KEY([ProjectID])
REFERENCES [dbo].[project] ([pk_id])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[template] CHECK CONSTRAINT [template_project_projectid]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT (NULL) FOR [Name]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT (NULL) FOR [Remark]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT ('1') FOR [State]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT (NULL) FOR [Guide]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT ('0') FOR [SignAgreement]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT ('1') FOR [Rank]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT ('1') FOR [GoBack]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT ('1') FOR [ParticipantMask]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT ('0') FOR [WaitBeforeNext]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT (NULL) FOR [Active]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT (NULL) FOR [UpdatedAt]
GO

ALTER TABLE [dbo].[template] ADD  DEFAULT (NULL) FOR [UpdatedBy]
GO






/****** Object:  Table [dbo].[question]    Script Date: 07/13/2017 00:33:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[question](
	[pk_id] [bigint] NOT NULL,
	[ID] [bigint] NOT NULL,
	[TemplateID] [bigint] NOT NULL,
	[Type] [int] NOT NULL,
	[Number] [varchar](32) NOT NULL,
	[Title] [varchar](2048) NOT NULL,
	[ImageUrl] [varchar](256) NULL,
	[VideoUrl] [varchar](256) NULL,
	[Optional] [bit] NULL,
	[Help] [varchar](256) NULL,
	[Layout] [int] NULL,
	[DispIndex] [int] NULL,
	[SelectionMax] [int] NULL,
	[SelectionMin] [int] NULL,
	[RowDisordered] [bit] NULL,
	[MatrixPivot] [bit] NULL,
	[RowLastFixed] [bit] NULL,
	[ColDisordered] [bit] NULL,
	[ColLastFixed] [bit] NULL,
	[ColumnCount] [int] NULL,
	[BusinessType] [int] NULL,
	[ScoreType] [int] NULL,
	[RowReverse] [bit] NULL,
	[ColReverse] [bit] NULL,
	[ChartType] [int] NULL,
	[Active] [bit] NULL,
	[CreatedAt] [datetime] NULL,
	[CreatedBy] [varchar](32) NULL,
	[UpdatedAt] [datetime] NULL,
	[UpdatedBy] [varchar](32) NULL,
PRIMARY KEY CLUSTERED 
(
	[pk_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [ImageUrl]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [VideoUrl]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [Help]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [Layout]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [DispIndex]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('0') FOR [SelectionMax]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('0') FOR [SelectionMin]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('0') FOR [RowDisordered]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('1') FOR [MatrixPivot]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('1') FOR [RowLastFixed]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('0') FOR [ColDisordered]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('1') FOR [ColLastFixed]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('1') FOR [ColumnCount]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('0') FOR [BusinessType]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('1') FOR [ScoreType]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('0') FOR [RowReverse]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('0') FOR [ColReverse]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('1') FOR [ChartType]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT ('1') FOR [Active]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [CreatedAt]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [CreatedBy]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [UpdatedAt]
GO

ALTER TABLE [dbo].[question] ADD  DEFAULT (NULL) FOR [UpdatedBy]
GO






/****** Object:  Table [dbo].[queoption]    Script Date: 07/13/2017 00:33:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[queoption](
	[pk_id] [bigint] NOT NULL,
	[ID] [bigint] NOT NULL,
	[QuestionID] [bigint] NOT NULL,
	[Code] [varchar](8) NOT NULL,
	[Title] [varchar](2048) NOT NULL,
	[ImageUrl] [varchar](256) NULL,
	[VideoUrl] [varchar](256) NULL,
	[open] [bit] NULL,
	[Help] [varchar](256) NULL,
	[DispIndex] [int] NULL,
	[BlankType] [int] NULL,
	[BlankMax] [int] NULL,
	[BlankMin] [int] NULL,
	[BlankOptional] [bit] NULL,
	[Value] [int] NULL,
	[Exclusive] [bit] NULL,
	[ThumbUrl] [varchar](256) NULL,
	[BlankRows] [int] NULL,
	[BlankCols] [int] NULL,
	[Orientation] [int] NOT NULL,
	[ShowValue] [bit] NULL,
	[ShowTip] [bit] NULL,
	[ShowCancel] [bit] NULL,
	[SelectionMax] [int] NULL,
	[SelectionMin] [int] NULL,
	[Active] [bit] NULL,
	[CreatedAt] [datetime] NOT NULL,
	[CreatedBy] [varchar](32) NOT NULL,
	[UpdatedAt] [datetime] NULL,
	[UpdatedBy] [varchar](32) NULL,
PRIMARY KEY CLUSTERED 
(
	[pk_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[queoption]  WITH CHECK ADD  CONSTRAINT [option_question_questionid] FOREIGN KEY([QuestionID])
REFERENCES [dbo].[question] ([pk_id])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[queoption] CHECK CONSTRAINT [option_question_questionid]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [ImageUrl]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [VideoUrl]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [Help]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [DispIndex]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('1') FOR [BlankType]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('0') FOR [BlankMax]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('0') FOR [BlankMin]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [BlankOptional]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('0') FOR [Value]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('0') FOR [Exclusive]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [ThumbUrl]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [BlankRows]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [BlankCols]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('1') FOR [Orientation]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('1') FOR [ShowValue]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('1') FOR [ShowTip]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT ('1') FOR [ShowCancel]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [SelectionMax]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [SelectionMin]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [UpdatedAt]
GO

ALTER TABLE [dbo].[queoption] ADD  DEFAULT (NULL) FOR [UpdatedBy]
GO






